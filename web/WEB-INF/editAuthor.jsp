<%@ page import="model.Author" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 04.09.2022
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Author Page</title>
</head>
<body>

<%
    Author author = (Author) request.getAttribute("author");

%>
Please update author's data
<form action="/authors/edit" , method="post">
    <input type="hidden" name="authorId" value="<%=author.getId()%>">
    <input type="text" name="name" value="<%=author.getName()%>"/><br>
    <input type="text" name="surname" value="<%=author.getSurname()%>"/><br>
    <input type="text" name="email" value="<%=author.getEmail()%>"/><br>
    <input type="number" name="age" value="<%=author.getAge()%>"/><br>

    <input type="submit" value="Update">
</form>
</body>
</html>
