<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改奖品</title>
<body>
<%
    String rid=request.getParameter("rid");
    request.setAttribute("rid",rid);
%>
<h3 align="center">填写信息</h3>
<form name="form1" method="post" action="editrewardservlet?rid=<%=rid%>">
    <table width="500" border="0" align="center">
        <tr>
            <td width="150" height="30">奖品名称:</td>
            <td width="400"><input name="name" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">所需积分:</td>
            <td width="400"><input name="cost" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">数量:</td>
            <td width="400"><input name="sum" type="text"></td>
        </tr>
        <tr>
            <td height="30" align="center" colspan="2">
                <input type="submit" name="submit" value="提交修改">
            </td>
        </tr>
    </table>
</form>

</body>

</html>