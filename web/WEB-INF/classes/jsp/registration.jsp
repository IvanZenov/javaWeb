
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post">
    First Name: <input type="text" name="firstName">
    <br>
    Second Name: <input type="text" name="secondName">
    <br>

    Email: <input type="text" name="email">
    <br>

    Password: <input type="password" name="password">
    <br>

    Phone Number: <input type="number" min="0" name="phoneNumber">
    <br>

    <a href="login">Login</a>
    <br>
    <input type="submit" value="Registration">
</form>
</body>
</html>
