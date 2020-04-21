<%--
  Created by IntelliJ IDEA.
  User: Zevs
  Date: 31.03.2020
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Data</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/saveData" method="post">
    <label for = "data">Enter data:</label>
    <input id="data" name="dataToSave">
    <button type="submit">Submit</button>

</form>

</body>
</html>
