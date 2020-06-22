<%--
  Created by IntelliJ IDEA.
  User: jetfree
  Date: 2020-02-07
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC Demo - Home page</title>
    <H1>Spring MVC Demo - Home page</H1>
</head>
<body>
<hr>
    <a href="hello/showForm">Hello World form</a>
<hr>
    <a href="student/showForm">Student form</a>
<hr>
    <a href="customer/showForm">Customer form</a>
<hr>
<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png" align="center">
</body>
</html>
