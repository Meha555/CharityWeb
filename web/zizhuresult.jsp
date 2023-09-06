<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资助结果</title>
</head>
<body>
<%="完成"+session.getAttribute("msg")+"次资助"%>
</body>
<script type="text/javascript">
    setTimeout("javascript:location.href='showchildinfoservlet'", 3000);
</script>
</html>
