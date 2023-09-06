<%@ page import="java.util.ArrayList" %>
<%@ page import="com.huiaicharity.entity.BBS" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>论坛</title>
    <link rel="stylesheet" type="text/css" href="static/css/showlist_universal.css">
    <style>
        #main {
            text-align: center;
            font-family: "华文楷体";
            width: 95%;
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
            width: 95%;
            height: 85%;
            border-collapse: collapse;
            text-align: center;
        }

        table td,
        table th {
            height: 8px;
            border: 1px solid #cad9ea;
            color: rgb(102, 102, 102);
        }

        table thead th {
            height: 8px;
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
            <span class="header"><a href="personal_center.html">🏦汇爱儿童资助网</a></span>
        </div>
        <div class="right">
            <a href="showpersonalinfoservlet">👮‍♂️个人信息</a>
            <a href="rewardinfoservlet">🎁积分商城</a>
            <a href="loginregister.html">👉退出</a>
        </div>
    </div>
    <div id="main">
        <h2>帖子列表</h2>
        <hr class="xuxian">
        <form action="fatieservlet" method="post">
            <table border="4" align="center" width="100%" height="70%">
                <tr>
                    <th>序号</th>
                    <th>标题</th>
                    <th>发帖时间</th>
                    <th>作者</th>
                    <th>内容</th>
                </tr>
                <% ArrayList<BBS> bbslist = (ArrayList<BBS>) request.getAttribute("bbslist");
                    for (int i = 0; i < bbslist.size(); i++) { BBS bbs=bbslist.get(i); %>
                <tr>
                    <td>
                        <%=bbs.getBid()%>
                    </td>
                    <td>
                        <%=bbs.getTitle()%>
                    </td>
                    <td>
                        <%=bbs.getTime()%>
                    </td>
                    <td>
                        <%=bbs.getAuthor()%>
                    </td>
                    <td>
                        <%=bbs.getContent()%>
                    </td>
                </tr>
                <% } %>
                <tr>
                    <th colspan="7">发帖</th>
                </tr>
                <tr>
                    <td width="150" height="10">标题:</td>
                    <td width="400">
                        <input name="title" type="text">
                    </td>
                    <td width="150" height="30">作者:</td>
                    <td width="400">
                        <input name="author" type="text">
                    </td>
                    <th>操作</th>
                </tr>
                <tr>
                    <td width="150">内容:</td>
                    <td width="400" colspan="3">
                        <textarea id="content" name="content" rows="4" cols="60" style="height: 90%;width: 100%"></textarea>
                    </td>
                    <td height="30" align="center" colspan="2">
                        <input type="submit" name="submit" value="发帖">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="footer">

        <ul>
            <li>--------Java Web开发技术三级项目--------</li>
            <li>------- Copyright &copy; 黄祯彦 All rights reserved.-------</li>
        </ul>

    </div>
</div>

</body>

</html>