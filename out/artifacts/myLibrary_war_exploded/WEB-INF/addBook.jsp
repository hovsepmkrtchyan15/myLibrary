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
<div>
  <div style="width: 1000px; height: 300px; margin: 0 auto"><img src="/images/bookPage.png" ></div>
  <div>
    <%
      List<Author> authors = (List<Author>) request.getAttribute("authors");
    %>

    <form action="/book/add" , method="post", enctype="multipart/form-data">
      <input type="text" name="title" placeholder="Please input title"/><br>
      <input type="text" name="description" placeholder="Please input description"/><br>
      <input type="number" name="price" placeholder="Please input price"/><br>
      <select name="authorId">
        <%
          for (Author author : authors) {%>
        <option value="<%=author.getId()%>"> <%=author.getName()%> <%=author.getSurname()%> </option>
        <%}%>

      </select><br>
      <input type="file" name="bookPic"><br>
      <input type="submit" value="REGISTER">
    </form>
  </div>
</div>


</body>
</html>
