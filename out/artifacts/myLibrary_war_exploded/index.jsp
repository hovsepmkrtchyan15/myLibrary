<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 04.09.2022
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<%User user = (User) session.getAttribute("user");%>

<body>
MY LIBRARY<br>

<a href="/authors">Show All Authors</a>
<a href="/books">Show All Books</a>

<%if (user != null) {%>
<a href="/author/add">Add Authors</a>
<a href="/book/add">Add Books</a> <br>
<a href="/logout">LOGOUT</a>
<%}%>

<%if (user == null) {%>
<a href="/register"> USER REGISTER</a>
<a href="/login"> LOGIN</a>
<%}%>


</body>
</html>
