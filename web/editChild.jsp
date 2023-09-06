<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改儿童信息</title>
<body>
<%
    String cid=request.getParameter("cid");
    request.setAttribute("cid",cid);
%>
<h3 align="center">填写信息</h3>
<form name="form1" method="post" action="editchildservlet?cid=<%=cid%>">
    <table width="500" border="0" align="center">
        <tr>
            <td width="150" height="30">姓名:</td>
            <td width="400"><input name="name" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">性别:</td>
            <td width="400"><input name="sex" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">年龄:</td>
            <td width="400"><input name="age" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">地区:</td>
            <td width="400"><input name="region" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">当前状况:</td>
            <td width="400"><input name="situation" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">资助状态:</td>
            <td width="400"><input name="after_help" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">联系方式:</td>
            <td width="400"><input name="tell" type="text"></td>
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