<%--
  Created by IntelliJ IDEA.
  User: Zevs
  Date: 18.04.2020
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table>
        <tr>
            <td>Username:</td>
            <td><label>
                <input type="text" name="name">
            </label></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><label>
                <input type="password" name="password">
            </label></td>
        </tr>

        <tr>
            <td><input type="submit" name="submit" value="login"></td>
            <td><a href="registration.jsp">Registration</a></td>
        </tr>
    </table>
</form>

</body>
</html>
