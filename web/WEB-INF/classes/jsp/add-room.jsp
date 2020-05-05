
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new room</title>
</head>
<body>
    <h1>Add New</h1>
    <div style="width: 900px; margin-outside: auto; margin-right: auto">
        <form action="${pageContext.request.contextPath}/admin/addNewRoom" method="post">
            <label>
                Image Url: <br>
                <input type="text" name="imageUrl"><br>

                Name: <br>
                <input type="text" name="name"><br>

                Description <br>
                <textarea name="description" style="width: 400px;height: 200px;"></textarea>
                <br>
                Places
                <input type="number" name="places"><br>

                Price Per Night: <br>
                <input type="number" name="price"><br>

                <input type="checkbox" name="isFree" value="addToFavourite"> Free</input>

                <input type="submit" value="Submit">
            </label>

        </form>
    </div>
</body>
</html>
