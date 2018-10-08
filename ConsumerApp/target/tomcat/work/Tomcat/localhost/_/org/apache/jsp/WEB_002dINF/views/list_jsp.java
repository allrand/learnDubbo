/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-28 10:56:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("    <title> </title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../src/css/layui.css\" media=\"all\">\n");
      out.write("    <style>\n");
      out.write("        body{margin: 10px;}\n");
      out.write("        .demo-carousel{height: 200px; line-height: 200px; text-align: center;}\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"demoTable\">\n");
      out.write("    搜索ID：\n");
      out.write("    <div class=\"layui-inline\">\n");
      out.write("        <input class=\"layui-input\" name=\"id\" id=\"demoReload\" autocomplete=\"off\">\n");
      out.write("    </div>\n");
      out.write("    <button id=\"searchBtn\" class=\"layui-btn\" data-type=\"reload\">搜索</button>\n");
      out.write("    <button id=\"addBtn\" class=\"layui-btn\" data-type=\"reload\">新增</button>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<table class=\"layui-hide\" id=\"demo\" lay-filter=\"test\"></table>\n");
      out.write("\n");
      out.write("<script type=\"text/html\" id=\"barDemo\">\n");
      out.write("    <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">编辑</a>\n");
      out.write("    <a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script src=\"../../src/layui.js\"></script>\n");
      out.write("<script>\n");
      out.write("    layui.use(['laydate', 'laypage', 'layer', 'table'], function(){\n");
      out.write("        var laydate = layui.laydate     //日期\n");
      out.write("            ,laypage = layui.laypage    //分页\n");
      out.write("            ,layer = layui.layer        //弹层\n");
      out.write("            ,table = layui.table        //表格\n");
      out.write("\n");
      out.write("        //执行一个 table 实例\n");
      out.write("        table.render({\n");
      out.write("            elem: '#demo'\n");
      out.write("            ,height: 420\n");
      out.write("            ,url: '/user/listdata' //数据接口\n");
      out.write("            ,title: '用户表'\n");
      out.write("            ,page: true //开启分页\n");
      out.write("            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档\n");
      out.write("            ,totalRow: true //开启合计行\n");
      out.write("            ,cols: [[ //表头\n");
      out.write("                {type: 'checkbox', fixed: 'left'}\n");
      out.write("                ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}\n");
      out.write("                ,{field:'username', title:'用户名', width:120, edit: 'text'}\n");
      out.write("                ,{field:'sex', title:'性别', width:80, edit: 'text', sort: true}\n");
      out.write("                ,{field: 'birthday', title: '生日', width: 120}\n");
      out.write("                ,{field: 'address', title: '地址', width:160}\n");
      out.write("                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}\n");
      out.write("            ]],\n");
      out.write("            id: \"listData\"\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        //监听头工具栏事件\n");
      out.write("        table.on('toolbar(test)', function(obj){\n");
      out.write("            var checkStatus = table.checkStatus(obj.config.id)\n");
      out.write("                ,data = checkStatus.data; //获取选中的数据\n");
      out.write("            switch(obj.event){\n");
      out.write("                case 'add':\n");
      out.write("                    layer.msg('添加');\n");
      out.write("                    break;\n");
      out.write("                case 'update':\n");
      out.write("                    if(data.length === 0){\n");
      out.write("                        layer.msg('请选择一行');\n");
      out.write("                    } else if(data.length > 1){\n");
      out.write("                        layer.msg('只能同时编辑一个');\n");
      out.write("                    } else {\n");
      out.write("                        layer.alert('编辑 [id]：'+ checkStatus.data[0].id);\n");
      out.write("                    }\n");
      out.write("                    break;\n");
      out.write("                case 'delete':\n");
      out.write("                    if(data.length === 0){\n");
      out.write("                        layer.msg('请选择一行');\n");
      out.write("                    } else {\n");
      out.write("                        layer.msg('删除');\n");
      out.write("                    }\n");
      out.write("                    break;\n");
      out.write("            };\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        //监听行工具事件\n");
      out.write("        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter=\"对应的值\"\n");
      out.write("            var data = obj.data //获得当前行数据\n");
      out.write("                ,layEvent = obj.event; //获得 lay-event 对应的值\n");
      out.write("            if(layEvent === 'detail'){\n");
      out.write("                layer.msg('查看操作');\n");
      out.write("            } else if(layEvent === 'del'){\n");
      out.write("                layer.confirm('真的删除行么', function(index){\n");
      out.write("                    obj.del(); //删除对应行（tr）的DOM结构\n");
      out.write("                    layer.close(index);\n");
      out.write("                    //TODO 向服务端发送删除指令\n");
      out.write("                    table.reload('listData', {\n");
      out.write("                        url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/deluser'\n");
      out.write("                        ,where: {\n");
      out.write("                            id: data.id\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                });\n");
      out.write("            } else if(layEvent === 'edit'){\n");
      out.write("                layer.msg('编辑操作');\n");
      out.write("                console.log(data);\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${session.setAttribute(\"user\", data)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\n");
      out.write("                // layer.open({\n");
      out.write("                //     type: 2,\n");
      out.write("                //     area: ['800px', '550px'],\n");
      out.write("                //     content: '/user/edit'\n");
      out.write("                // });\n");
      out.write("                layer.prompt({\n");
      out.write("                    formType: 2\n");
      out.write("                    ,value: data.username\n");
      out.write("                }, function(value, index){\n");
      out.write("                    obj.update({\n");
      out.write("                        username: encodeURI(value)\n");
      out.write("                    });\n");
      out.write("                    layer.close(index);\n");
      out.write("                    //TODO 向服务端发送更新指令\n");
      out.write("                    table.reload('listData', {\n");
      out.write("                        url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/modify'\n");
      out.write("                        ,where: {\n");
      out.write("                            id: data.id,\n");
      out.write("                            username: encodeURI(value),\n");
      out.write("                            sex: data.sex,\n");
      out.write("                            address: encodeURI(data.address)\n");
      out.write("                        }\n");
      out.write("                    }, function (res) {\n");
      out.write("                        alert(res.msg)\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        //将日期直接嵌套在指定容器中\n");
      out.write("        var dateIns = laydate.render({\n");
      out.write("            elem: '#laydateDemo'\n");
      out.write("            ,position: 'static'\n");
      out.write("            ,calendar: true //是否开启公历重要节日\n");
      out.write("            ,mark: { //标记重要日子\n");
      out.write("                '0-10-14': '生日'\n");
      out.write("                ,'2018-08-28': '新版'\n");
      out.write("                ,'2018-10-08': '神秘'\n");
      out.write("            }\n");
      out.write("            ,done: function(value, date, endDate){\n");
      out.write("                if(date.year == 2017 && date.month == 11 && date.date == 30){\n");
      out.write("                    dateIns.hint('一不小心就月底了呢');\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            ,change: function(value, date, endDate){\n");
      out.write("                layer.msg(value)\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        //分页\n");
      out.write("        laypage.render({\n");
      out.write("            elem: 'pageDemo' //分页容器的id\n");
      out.write("            ,count: 10 //总页数\n");
      out.write("            ,skin: '#1E9FFF' //自定义选中色值\n");
      out.write("            //,skip: true //开启跳页\n");
      out.write("            ,jump: function(obj, first){\n");
      out.write("                if(!first){\n");
      out.write("                    layer.msg('第'+ obj.curr +'页', {offset: 'b'});\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("        var $ = layui.$;\n");
      out.write("\n");
      out.write("        $('#searchBtn').on('click', function () {\n");
      out.write("            var demoReload = $('#demoReload');\n");
      out.write("\n");
      out.write("            //执行重载\n");
      out.write("            table.reload('listData', {\n");
      out.write("                page: {\n");
      out.write("                    curr: 1 //重新从第 1 页开始\n");
      out.write("                }\n");
      out.write("                ,where: {\n");
      out.write("                    id:demoReload.val()\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        })\n");
      out.write("\n");
      out.write("        $('#addBtn').on('click', function () {\n");
      out.write("            layer.open({\n");
      out.write("                type: 2,\n");
      out.write("                area: ['800px', '550px'],\n");
      out.write("                content: '/user/add' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']\n");
      out.write("            });\n");
      out.write("        })\n");
      out.write("\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}