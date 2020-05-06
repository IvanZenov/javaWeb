<%@ page import="by.bsu.entity.Room" %>
<html>
<head>
    <title>Reservation</title>
</head>
<body>
        
     <img src="${requestScope.currentRoom.imageUrl}" alt="room"/>

     <p>Room name: ${requestScope.currentRoom.name}</p>
     <p>Room description: ${requestScope.currentRoom.description}</p>
     <p>Room places: ${requestScope.currentRoom.places}</p>
     <p>Room daily price: ${requestScope.currentRoom.dailyPrice}</p>

     <form action="${pageContext.request.contextPath}/reserve" method="POST">
         Arrival: <input type="date" name="arrival">
         <br>
         Checkout: <input type="date" name="checkout">
         <br>
         <input type="submit" value="Reserve">
     </form>

</body>
</html>
