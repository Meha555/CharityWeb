<%@ page import="java.util.ArrayList" %>
<%@ page import="com.huiaicharity.entity.Children" %>
<%@ page import="com.huiaicharity.entity.Projects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>公益项目列表</title>
    <link rel="stylesheet" type="text/css" href="static/css/showlist_universal.css">
    <style>
        #main {
            text-align: center;
            font-family: "华文楷体";
            width: 70%;
            height: 495px;
            border: 2px solid gray;
            margin: 20px auto;
            padding: 0px 15px;
            background: rgba(249, 246, 245, 0.411);
        }

        #main li {
            font-size: large;
            font-weight: bold;
            list-style: none;
            height: 38px;
            line-height: 40px;
            text-indent: 2em;
            /*缩进*/
            border-bottom: 2px dashed gray;
        }

        #footer {
            text-align: center;
            height: 10px;
            width: auto;
            color: white;
            background-color: midnightblue;
            padding: 60px 100px;
            margin: 0 auto;
            font-size: 20px;
            font-family: "宋体";
        }

        #footer li {
            list-style: none;
            line-height: 30px;
        }

        form {
            margin: 10px auto;
            height: 100%;
        }

        table {
            font-size: large;
            margin: 0px auto;
            padding: 0px;
            width: 100%;
            height: 80%;
            font-size: large;
            border-collapse: collapse;
            text-align: center;
        }

        table td,
        table th {
            border: 1px solid #cad9ea;
            color: rgb(102, 102, 102);
        }

        table thead th {
            background-color: rgba(204, 232, 235, 0.864);
        }

        table tr:nth-child(odd) {
            background: rgb(255, 255, 255);
        }

        table tr:nth-child(even) {
            background: rgba(245, 250, 250, 0.864);
        }
    </style>
</head>

<body>
<div>
    <div id="nav">
        <div class="left">
            <span class="header"><a href="personal_center.html">🌳汇爱儿童资助网</a></span>
        </div>
        <div class="right">
            <a href="showpersonalinfoservlet">👮‍♂️个人信息</a>
            <a href="rewardinfoservlet">🎁积分商城</a>
            <a href="loginregister.html">👉退出</a>
        </div>
    </div>
    <div id="main">
        <h2>公益项目列表</h2>
        <hr class="xuxian">
        <form action="addprojectservlet" method="post">
            <table border="4" align="center" width="100%" height="70%">
                <tr>
                    <th>序号</th>
                    <th>名称</th>
                    <th>组织者</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th colspan="2">操作</th>
                </tr>
                <tr>
                    <td><input type="text" name="pid" PLACEHOLDER="管理员ID"/></td>
                    <td><input type="text" name="name" PLACEHOLDER="名称"/></td>
                    <td><input type="text" name="organizer" PLACEHOLDER="组织者"/></td>
                    <td><input type="text" name="start_time" PLACEHOLDER="开始时间"/></td>
                    <td><input type="text" name="end_time" PLACEHOLDER="结束时间"/></td>
                    <td colspan="2"><input type="submit" value="增加"></td>
                </tr>
                <%
                    ArrayList<Projects> projectlist = (ArrayList<Projects>) session.getAttribute("projectlist");
                    for (int i = 0; i < projectlist.size(); i++) {
                        Projects p = projectlist.get(i);
                %>
                <tr>
                    <td><%=p.getPid()%>
                    </td>
                    <td><%=p.getName()%>
                    </td>
                    <td><%=p.getOrganizer()%>
                    </td>
                    <td><%=p.getStart_date()%>
                    </td>
                    <td><%=p.getEnd_date()%>
                    </td>
                    <td><a class="edit" href="<%=request.getContextPath()%>/editProject.jsp?pid=<%=p.getPid()%>">编辑</a>
                    </td>
                    <td><a class="del" href="<%=request.getContextPath()%>/delprojectservlet?pid=<%=p.getPid()%>">删除</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </form>
    </div>
    <div id="footer">

        <ul>
            <li>--------课设--------</li>
            <li>------- Copyright &copy; 黄祯彦 All rights reserved.-------</li>
        </ul>

    </div>
</div>

</body>

</html>