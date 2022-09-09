<%@ page import="model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 04.09.2022
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users Page</title>
</head>
<body>
<%
    List<Book> bookList = (List<Book>) request.getAttribute("books");
%>

<table border="1">
    <tr>
        <th>image</th>
        <th>id</th>
        <th>title</th>
        <th>description</th>
        <th>price</th>
        <th>authorId</th>
        <th>action</th>

    </tr>
    <%
        for (Book book : bookList) {
    %>
    <tr>
        <td>
            <%if (book.getBookPic() == null || book.getBookPic().length() == 0) {%>
            <img src="/images/bookDefaulAvatar.png" width="80">
            <%} else {%>
            <img src="/getBookImage?bookPic=<%=book.getBookPic()%>" width="80">
            <%}%>
        </td>
        <td><%=book.getId()%>
        </td>
        <td><%=book.getTitle()%>
        </td>
        <td><%=book.getDescription()%>
        </td>
        <td><%=book.getPrice()%>
        </td>
        <td>
            <% if (book.getAuthor() != null) {%>
            <%=book.getAuthor().getName()%>
            <%} else {%>
            <span style="color: #fc1d1d">no author</span>
            <%}%>
        </td>

        <td>
            <a href="/books/delete?bookId=<%=book.getId()%>">Delete</a> |
            <a href="/books/edit?bookId=<%=book.getId()%>">Edit</a>
        </td>
    </tr>

    <% }
    %>
</table>
</body>
</html>
