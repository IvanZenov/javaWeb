
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Reservation</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>

</head>
<body>

<table class="container">
    <thead>
    <tr>
        <th>ID</th>
        <th>User ID</th>
        <th>Room ID</th>
        <th>Arrival</th>
        <th>Checkout</th>
        <th>Status</th>
        <th>Action Status</th>
        <th>Apply</th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.reservations}" var="reservation">
        <tbody>
        <tr>
            <td id="reservationId">${reservation.id}</td>
            <td id="userId">${reservation.user_id}</td>
            <td>${reservation.room_id}</td>
            <td>${reservation.arrival}</td>
            <td>${reservation.checkout} $</td>
            <td>${reservation.status}</td>
            <td>
                <select name="statusId" id="status">
                    <option>Confirm</option>
                    <option>Reject</option>
                </select>
            </td>
            <td><button type="button" onclick="applyReservation()"></button></td>

        </tr>
        </tbody>
    </c:forEach>
</table>



</body>
</html>
