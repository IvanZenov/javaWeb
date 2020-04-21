<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artist Form</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/saveArtist" method="post">
        <label for="name">Artist Name</label>
        <input id="name" name="name">
        <button type="submit">Save Artist</button>
    </form>
</body>
</html>
