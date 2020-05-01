<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Second Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Role</th>
            <th>Money</th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.users}" var="room">
            <tbody>
            <tr>
                <td>${room.id}</td>
                <td>${room.firstName}</td>
                <td>${room.secondName}</td>
                <td>${room.email}</td>
                <td>${room.phoneNumber}</td>
                <td>${room.role} </td>
                <td>${room.money} $</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</body>
</html>
