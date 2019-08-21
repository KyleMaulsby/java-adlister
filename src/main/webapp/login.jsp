<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: kylemaulsby
  Date: 2019-08-21
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Title</title>
    <link rel="stylesheet" href="./index.css">
</head>
<body>

<form method="Post" action="./login.jsp">
    <label for="User">Username:</label>
    <input type="text" id="User" name="User">
    <label for="Pass">Password: </label>
    <input type="password" id="Pass" name="Pass">
    <button type="submit">Submit</button>
</form>


<c:if test="${param.User == 'admin' && param.Pass == 'password'}">
<%--    <c:redirect url="/profile.jsp"/>--%>
        <% response.sendRedirect("/profile.jsp"); %>
</c:if>
<c:if test="${(param.userName != 'admin' && param.Pass !='password')||
              (param.userName != null || param.Pass !=null)}">
    <h2>Please enter a valid username or password</h2>
</c:if>
</body>
</html>
