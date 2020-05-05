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

</body>
</html>
