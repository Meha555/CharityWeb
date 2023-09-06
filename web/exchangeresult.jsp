<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资助结果</title>
</head>
<body>
<%="已兑换"+session.getAttribute("msg")+""%>
</body>
<script type="text/javascript">
setTimeout("javascript:location.href='rewardinfoservlet'", 3000);
</script>

</html>
