<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- TODO: add style css-->
    <title>Rooms</title>

    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h2>All Rooms</h2>

<table class="container">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Places</th>
        <th>Price Per Night</th>
        <th>Free</th>
        <th>Action</th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.rooms}" var="room">
        <tbody>
            <tr>
                <td>${room.id}</td>
                <td>${room.name}</td>
                <td>${room.description}</td>
                <td>${room.places}</td>
                <td>${room.dailyPrice} $</td>
                <td>${room.free}</td>
                <td>
                    <c:choose>
                        <c:when test="${room.free eq true}">
                            <a href="reserve?id=${room.id}">Reserve</a>
                        </c:when>
                    </c:choose>
                </td>

            </tr>
        </tbody>
    </c:forEach>
</table>


</body>
</html>
