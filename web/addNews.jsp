<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>写新闻</title>

<body>
<% String rid=request.getParameter("rid"); request.setAttribute("rid",rid); %>
<h3 align="center">写新闻</h3>
<form name="form1" method="post" action="addnewsservlet">
    <table width="500" border="0" align="center">
        <tr>
            <td width="150" height="30">新闻标题:</td>
            <td width="400"><input name="title" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">作者:</td>
            <td width="400"><input name="author" type="text"></td>
        </tr>
        <tr>
            <td width="150" height="30">新闻内容:</td>
            <td width="400">
                <textarea name="content" id="content" cols="30" rows="10"></textarea>
        </tr>
        <tr>
            <td width="150" height="30">媒体文件名:</td>
            <td width="400"><input name="media" type="text"></td>
        </tr>
        <tr>
            <td height="30" align="center" colspan="2">
                <input type="submit" name="submit" value="提交">
            </td>
        </tr>
    </table>
</form>

</body>

</html>