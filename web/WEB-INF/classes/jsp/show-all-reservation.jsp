
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Reservation</title>
</head>
<body>
<c:forEach items="${requestScope.reservations}" var="reserv">
    <tbody>
    <tr>
        <td>${reserv.id}</td>
        <td>${reserv.user_id}</td>
        <td>${reserv.room_id}</td>
        <td>${reserv.arrival}</td>
        <td>${reserv.checkout}</td>
        <td>${reserv.status}</td>
        <td>
            <!-- TODO: dropdown menu with admin action -->
          <!--  <a methods="post" act="${pageContext.request.contextPath}/admin/reservation?id=?">Reserve</a> -->
        </td>

    </tr>
    </tbody>
</c:forEach>

</body>
</html>
