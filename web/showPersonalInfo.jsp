<%@ page import="java.util.ArrayList" %>
<%@ page import="com.huiaicharity.entity.Users" %>
<%@ page import="com.huiaicharity.service.UsersService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>个人信息</title>
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
        .submit {
            width: 140px;
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
        <h2>个人信息</h2>
        <hr class="xuxian">
        <% Users users = (Users) session.getAttribute("user");String uid=users.getUid();
            UsersService usersService=new UsersService();
            Users user=usersService.selectUserByUID(uid);
            session.setAttribute("user",user);
        %>
        <form action="editpersonalinfoservlet?uid=<%=uid%>" method="post">
            <table border="4" align="center" width="100%" height="70%">
                <tr>
                    <th>UID</th>
                    <th>用户名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>电子邮箱</th>
                </tr>
                <tr>
                    <td>
                        <%=user.getUid()%>
                    </td>
                    <td>
                        <%=user.getName()%>
                    </td>
                    <td>
                        <%=user.getSex()%>
                    </td>
                    <td>
                        <%=user.getAge()%>
                    </td>
                    <td>
                        <%=user.getEmail()%>
                    </td>
                </tr>
                <tr>
                    <th>地址</th>
                    <th>是否为志愿者</th>
                    <th>电话号码</th>
                    <th>密码</th>
                    <th>身份证号</th>
                </tr>
                <tr>
                    <td>
                        <%=user.getAddress()%>
                    </td>
                    <td>
                        <%=user.getIs_volunteer()%>
                    </td>
                    <td>
                        <%=user.getTell()%>
                    </td>
                    <td>
                        <%=user.getPwd()%>
                    </td>
                    <td>
                        <%=user.getIdentity()%>
                    </td>
                </tr>
                <tr>
                    <td>UID:<%=uid%></td>
                    <td><input type="text" name="name" PLACEHOLDER="用户名"/></td>
                    <td><input type="text" name="sex" PLACEHOLDER="性别"/></td>
                    <td><input type="text" name="age" PLACEHOLDER="年龄"/></td>
                    <td><input type="text" name="email" PLACEHOLDER="电子邮箱"/></td>
                </tr>
                <tr>
                    <td><input type="text" name="address" PLACEHOLDER="地址"/></td>
                    <td><input type="text" name="is_volunteer" PLACEHOLDER="是否为志愿者"/></td>
                    <td><input type="text" name="tell" PLACEHOLDER="电话号码"/></td>
                    <td><input type="text" name="password" PLACEHOLDER="密码"/></td>
                    <td><input type="text" name="identity" PLACEHOLDER="身份证号"/></td>
                </tr>
                <tr>
                    <td colspan="10"><input class="submit" type="submit" value="修改"></td>
                </tr>
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