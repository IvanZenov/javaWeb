<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Room</title>
</head>
<body>
    <p>Name: ${requestScope.room.name}</p>
    <p>Description: ${requestScope.room.description}</p>
    <p>Places: ${requestScope.room.places}</p>
    <p>Price: ${requestScope.room.price}</p>

</body>
</html>
