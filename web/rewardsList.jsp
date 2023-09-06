<%@ page language="java" import="java.sql.*" %>
<%@ page import="java.util.ArrayList" contentType="text/html;charset=utf-8" %>
<%@ page import="com.huiaicharity.entity.Rewards" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>资助列表</title>
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
        <h2>积分商城</h2>
        <hr class="xuxian">
        <form name="form1" method="post" action="exchangeservlet">
            <table border="2" style="text-align:center;">
                <tr>
                    <th>序号</th>
                    <th>名称</th>
                    <th>积分</th>
                    <th>数量</th>
                </tr>
                <% ArrayList<Rewards> rewardlist = (ArrayList<Rewards>) request.getAttribute("rewardlist");
                    for (int i = 0; i < rewardlist.size(); i++) {
                        Rewards v = rewardlist.get(i); %>
                <tr>
                    <td>
                        <%=v.getRid()%>
                    </td>
                    <td>
                        <%=v.getName()%>
                    </td>
                    <td>
                        <%=v.getCost()%>
                    </td>
                    <td>
                        <%=v.getSum()%>
                    </td>
                </tr>
                <% } %>
                <tr>
                    <td width="150" height="10">志愿者ID:</td>
                    <td width="400"><input name="vid" type="text"></td>
                    <td width="150" height="10">奖品ID:</td>
                    <td width="400"><input name="rid" type="text"></td>
                </tr>
                <tr>
                    <td width="150" height="10">数量：</td>
                    <td width="400"><input name="num" type="text"></td>
                    <td height="10" align="center" colspan="2">
                        <input type="submit" name="submit" value="兑换">
                    </td>
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
