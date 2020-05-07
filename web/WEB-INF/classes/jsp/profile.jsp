<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.bsu.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<%
    User user= (User) session.getAttribute("currentUser");
%>

    <p>First Name: <%=user.getFirstName()%></p>
    <p>Second Name: <%=user.getSecondName()%></p>
    <p>Email: <%=user.getEmail()%></p>
    <p>Phone: <%=user.getPhoneNumber()%></p>
    <p>Balance: <%=user.getMoney()%></p>

<br>
<p>Reservations</p>
<table class="container">
    <thead>
    <tr>
        <th>ID</th>
        <th>Room ID</th>
        <th>Arrival</th>
        <th>Checkout</th>
        <th>Status</th>
        <th>Payment</th>

    </tr>
    </thead>
    <c:forEach items="${requestScope.currentUserReservation}" var="reserv">
        <tbody>
        <tr>
            <td>${reserv.id}</td>
            <td>${reserv.roomId}</td>
            <td>${reserv.arrival}</td>
            <td>${reserv.checkout} $</td>
            <td>${reserv.status}</td>

            <td>
                <c:choose>
                    <c:when test="${reserv.status eq 'CONFIRMED'}">
                        <a href="reserve?id=${reserv.id}">Payment</a>
                    </c:when>
                </c:choose>
            </td>

        </tr>
        </tbody>
    </c:forEach>
</table>

</body>
</html>
