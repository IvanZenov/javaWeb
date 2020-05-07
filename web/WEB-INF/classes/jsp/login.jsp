
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    Email: <input type="text" name="email" id="email">
    <br>
    Password: <input type="password" name="password" id="password">
    <br>
    <a href="registration">Registration</a>
    <br>
    <input type="submit" value="Login">

</form>

</body>
</html>
