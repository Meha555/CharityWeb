<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改志愿活动</title>
<body>
<%
    String actid=request.getParameter("actid");
    request.setAttribute("actid",actid);
%>
<h3 align="center">填写信息</h3>
<form name="form1" method="post" action="editactivityservlet?actid=<%=actid%>">
    <table width="500" border="0" align="center">
        <tr>
            <td width="150" height="30">活动名称:</td>
            <td width="400"><input name="name" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">活动地点:</td>
            <td width="400"><input name="address" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">开始日期:</td>
            <td width="400"><input name="start_time" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">结束日期:</td>
            <td width="400"><input name="end_time" type="text"></td>
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