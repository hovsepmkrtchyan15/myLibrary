<%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 09.09.2022
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<%
    String msg = (String) request.getAttribute("msg");
%>
<%if(msg !=null){%>
<p style="color: red"><%=msg%></p>
<%}%>

<form action="/login" method="post">
    <input type="email" name="email" placeholder="Please input Email"/><br><br>
    <input type="password" name="password" placeholder="Please input Password"/><br><br>
    <input type="submit" value="LOGIN"/>
</form>
</body>
</html>
