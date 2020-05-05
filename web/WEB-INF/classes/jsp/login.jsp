
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    Email: <input type="text" name="email">
    <br>
    Password: <input type="password" name="password">
    <br>
    <a href="registration">Registration</a>
    <br>
    <input type="submit" value="Login">
</form>

</body>
</html>
