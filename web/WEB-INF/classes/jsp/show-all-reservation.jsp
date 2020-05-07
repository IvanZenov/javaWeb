<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Reservation</title>
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
        <th>Admin Decision</th>
        <th></th>

    </tr>
    </thead>
    <c:forEach items="${requestScope.reservations}" var="reserv">
        <tbody>
        <tr>
            <td id="reservationId">${reserv.id}</td>
            <td>${reserv.userId}</td>
            <td>${reserv.roomId}</td>
            <td>${reserv.arrival}</td>
            <td>${reserv.checkout} $</td>
            <td>${reserv.status}</td>
            <td>
                <label>
                    <select name="statusId" id="status-id">
                        <option>Confirm</option>
                        <option>Reject</option>
                    </select>
                </label>
            </td>
            <td>
                <button type="button" onclick="applyReservation()">Send Decision</button>
            </td>
        </tr>
        </tbody>
    </c:forEach>
</table>

</body>
</html>
