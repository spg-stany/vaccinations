<%--
  Created by IntelliJ IDEA.
  User: AAukhatov
  Date: 01.02.2017
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gradle + Spring MVC</title>
</head>
<body>
    <h1>${title}</h1>
    <p>
        <c:if test="${not empty msg}">
            Hello ${msg}
        </c:if>

        <c:if test="${empty msg}">
            Welcome Welcome!
        </c:if>
    </p>
</body>
</html>
