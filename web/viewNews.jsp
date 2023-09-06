<%@ page import="com.huiaicharity.entity.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  News news= (News) request.getAttribute("news");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title><%=news.getTitle()%></title>
  <link rel="stylesheet" type="text/css" href="/static/css/showlist_universal.css">
  <style>
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

    .article {
      text-indent: 2em;
      margin: 50px 60px;
      width: 1200px;
      height: 100%;
      border: 2px solid #D9E0EE;
      border-top: 10px double rgba(60, 0, 0, 0.6);
      padding: 10px 50px;
      box-shadow: 0 15px 30px rgba(0, 0, 0, .4);
      font: normal 700 20px/40px KaiTi_GB2312；
    }
    .studio {
      margin: 30px;
      width: 1300px;
      height: 800px;
    }

    #btn-top {
      position: fixed;
      right: 30px;
      top: 400px;
    }
  </style>
</head>

<body style="background-image: none;background-color: white;">
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
  <div class="article">
    <h1 align="center"><%=news.getTitle()%></h1>
    <div>
      <div class="studio" id="media">
        <video width="86%" height="86%" controls autoplay loop>
          <source src="static/video/<%=news.getMedia()%>" type="video/mp4">
        </video>
      </div>
      <h3><i>作者：<span id="author"><%=news.getAuthor()%></span></i> <span class="right"><%=news.getTime()%></span></h3>
      <hr height="10px">
      <p id="content"><%=news.getContent()%></p>
    </div>
  </div>
  <div id="btn-top"><a href="#top"><img src="/static/image/top.jpeg" alt="返回顶部" title="返回顶部" width="50px"></a>
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