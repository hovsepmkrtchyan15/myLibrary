<%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 04.09.2022
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author Page</title>
</head>
<body>
<form action="/author/add" , method="post">
    <input type="text" name="name" placeholder="Please input name"/><br>
    <input type="text" name="surname" placeholder="Please input surname"/><br>
    <input type="email" name="email" placeholder="Please input email"/><br>
    <input type="number" name="age" placeholder="Please input age"/><br>

    <input type="submit" value="ADD">
</form>
</body>
</html>
