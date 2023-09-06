<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打卡结果</title>
</head>
<body>
<%="已发送"+session.getAttribute("msg")+"次申请"%>
</body>
<script type="text/javascript">
    setTimeout("javascript:location.href='volunteer.html'", 3000);
</script>
</html>
