<%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 09.09.2022
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
<form action="/register" method="post">
    <input type="text" name="name" placeholder="Please input name"/><br><br>
    <input type="text" name="surname" placeholder="Please input surname"/><br><br>
    <input type="email" name="email" placeholder="Please input email"/><br><br>
    <input type="password" name="password" placeholder="Please input password"/><br><br>
    <input type="submit" value="REGISTER"/>
</form>
</body>
</html>
