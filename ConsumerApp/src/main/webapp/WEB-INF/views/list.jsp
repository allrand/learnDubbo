<%--
  Created by IntelliJ IDEA.
  User: randall
  Date: 25/9/2018
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title> </title>
    <link rel="stylesheet" href="../../src/css/layui.css" media="all">
    <style>
        body{margin: 10px;}
        .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
    </style>
</head>
<body>

<div class="demoTable">
    搜索ID：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button id="searchBtn" class="layui-btn" data-type="reload">搜索</button>
    <button id="addBtn" class="layui-btn" data-type="reload">新增</button>
</div>

<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="../../src/layui.js"></script>
<script>
    layui.use(['laydate', 'laypage', 'layer', 'table'], function(){
        var laydate = layui.laydate     //日期
            ,laypage = layui.laypage    //分页
            ,layer = layui.layer        //弹层
            ,table = layui.table        //表格

        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,height: 420
            ,url: '/user/listdata' //数据接口
            ,title: '用户表'
            ,page: true //开启分页
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
                ,{field:'username', title:'用户名', width:120, edit: 'text'}
                ,{field:'sex', title:'性别', width:80, edit: 'text', sort: true}
                ,{field: 'birthday', title: '生日', width: 120}
                ,{field: 'address', title: '地址', width:160}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]],
            id: "listData"
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    layer.msg('添加');
                    break;
                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                    }
                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                layer.msg('查看操作');
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //TODO 向服务端发送删除指令
                    table.reload('listData', {
                        url: '${pageContext.request.contextPath}/user/deluser'
                        ,where: {
                            id: data.id
                        }
                    });

                });
            } else if(layEvent === 'edit'){
                layer.msg('编辑操作');
                console.log(data);
                ${session.setAttribute("user", data)}

                // layer.open({
                //     type: 2,
                //     area: ['800px', '550px'],
                //     content: '/user/edit'
                // });
                layer.prompt({
                    formType: 2
                    ,value: data.username
                }, function(value, index){
                    obj.update({
                        username: encodeURI(value)
                    });
                    layer.close(index);
                    //TODO 向服务端发送更新指令
                    table.reload('listData', {
                        url: '${pageContext.request.contextPath}/user/modify'
                        ,where: {
                            id: data.id,
                            username: encodeURI(value),
                            sex: data.sex,
                            address: encodeURI(data.address)
                        }
                    }, function (res) {
                        alert(res.msg)
                    });
                });
            }
        });

        //将日期直接嵌套在指定容器中
        var dateIns = laydate.render({
            elem: '#laydateDemo'
            ,position: 'static'
            ,calendar: true //是否开启公历重要节日
            ,mark: { //标记重要日子
                '0-10-14': '生日'
                ,'2018-08-28': '新版'
                ,'2018-10-08': '神秘'
            }
            ,done: function(value, date, endDate){
                if(date.year == 2017 && date.month == 11 && date.date == 30){
                    dateIns.hint('一不小心就月底了呢');
                }
            }
            ,change: function(value, date, endDate){
                layer.msg(value)
            }
        });

        //分页
        laypage.render({
            elem: 'pageDemo' //分页容器的id
            ,count: 10 //总页数
            ,skin: '#1E9FFF' //自定义选中色值
            //,skip: true //开启跳页
            ,jump: function(obj, first){
                if(!first){
                    layer.msg('第'+ obj.curr +'页', {offset: 'b'});
                }
            }
        });
        var $ = layui.$;

        $('#searchBtn').on('click', function () {
            var demoReload = $('#demoReload');

            //执行重载
            table.reload('listData', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    id:demoReload.val()
                }
            });
        })

        $('#addBtn').on('click', function () {
            layer.open({
                type: 2,
                area: ['800px', '550px'],
                content: '/user/add' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            });
        })

    });
</script>
</body>
</html>
