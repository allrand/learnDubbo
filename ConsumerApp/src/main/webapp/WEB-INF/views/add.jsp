<%--
  Created by IntelliJ IDEA.
  User: randall
  Date: 27/9/2018
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../src/css/layui.css" media="all">
</head>
<body>


<!-- 示例-970 -->

<form class="layui-form" action="" lay-filter="example">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入用户名"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-block">
            <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="2" title="男" checked="">
            <input type="radio" name="sex" value="1" title="女">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入地址" class="layui-textarea" name="address"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">日期选择</label>
            <div class="layui-input-block">
                <input type="text" name="birthday" id="date" autocomplete="off" class="layui-input">
                <%--id="date"--%>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">提交</button>
        </div>
    </div>
</form>

<script src="../../src/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , $ = layui.jquery;

        //日期
        laydate.render({
            elem: '#date'
            // elem: '#birthday'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 2) {
                    return '标题至少得2个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            // alert(JSON.stringify(data.field))
            console.log(data)
            console.log(data.field)
            // $.post("/user/adduser", data.field, function (result) {
            //
            //     layer.msg(result.msg, {
            //         icon: 1,
            //         time: 2000, //2s后自动关闭
            //     }, function () {
            //         parent.window.location.reload();
            //     });
            // },'application/json;charset=UTF-8')
            //
            $.ajax({
                type: "post",
                url: "/user/adduser",
                // data: data.field,
                data: JSON.stringify(data.field),
                contentType: "application/json; charset=utf-8",
                success: function (result) {
                    layer.msg(result.msg, {
                        icon: 1,
                        time: 2000, //2s后自动关闭
                    }, function () {
                        parent.window.location.reload();
                    });
                }
            });

            return false;
        });

        //表单初始赋值
        form.val('example', {
            // "username": "测试账号123"
            // ,"password": "123123"
            // ,"birthday": ""
            // ,"sex": "女"
            // ,"address": "北京市"
            "username": ""
            ,"password": ""
            ,"birthday": ""
            ,"sex": "女"
            ,"address": ""
        })


    });
</script>

</body>
</html>
