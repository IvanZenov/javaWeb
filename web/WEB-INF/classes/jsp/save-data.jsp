
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
