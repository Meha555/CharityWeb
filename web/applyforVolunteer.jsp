<%@ page import="com.huiaicharity.entity.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>申请加入志愿者</title>
<body>
<%
    Users user= (Users) session.getAttribute("user");
    String uid=user.getUid();
%>
<h3 align="center">填写信息</h3>
<form name="form1" method="post" action="addapplyservlet?uid=<%=uid%>">
    <table width="500" border="0" align="center">
        <tr>
            <td width="150" height="30">用户ID</td>
            <td width="400"><%=uid%></td>
        </tr>
        <tr>
            <td width="150" height="30">加入原因:</td>
            <td width="400">
                <textarea id="content" name="content" rows="5" cols="30">
                </textarea>
            </td>
        </tr>
        <tr>
            <td height="30" align="center" colspan="2">
                <input type="submit" name="submit" value="发送申请">
            </td>
        </tr>
    </table>
</form>

</body>

</html>