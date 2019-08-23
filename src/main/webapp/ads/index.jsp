<%--
  Created by IntelliJ IDEA.
  User: kylemaulsby
  Date: 2019-08-23
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>ads</title>
</head>
<body>
<h1>Heres the ads</h1>
<ul>
<c:forEach var="ad" items="${ads}">
    <li>
    <div>${ad.title}</div>
    <p>${ad.description}</p>
    </li>
</c:forEach>
</ul>
</body>
</html>
