<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打卡结果</title>
</head>
<body>
<%="打卡次数："+session.getAttribute("msg")%>
</body>
<script type="text/javascript">
    setTimeout("javascript:location.href='volunteer.html'", 3000);
</script>
</html>
