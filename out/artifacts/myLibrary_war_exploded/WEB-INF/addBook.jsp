<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Author" %><%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 04.09.2022
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book Page</title>
</head>
<body>

<%
  List<Author> authors = (List<Author>) request.getAttribute("authors");
%>

<form action="/book/add" , method="post">
  <input type="text" name="title" placeholder="Please input title"/><br>
  <input type="text" name="description" placeholder="Please input description"/><br>
  <input type="number" name="price" placeholder="Please input price"/><br>
  <select name="authorId">
    <%
      for (Author author : authors) {%>
    <option value="<%=author.getId()%>" ><%=author.getName()%> <%=author.getSurname()%> </option>
    <%}%>

  </select>
  <input type="submit" value="REGISTER">
</form>
</body>
</html>
