<%--
  Created by IntelliJ IDEA.
  User: jetfree
  Date: 2020-03-23
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student confirmation</title>
</head>
<body>
    Student is confirmed: ${student.firstName} ${student.lastName}
    <br><br>
    Country: ${student.country}
    <br><br>
    Favorite language: ${student.favoriteLanguage}
    <br><br>
    Operating systems:
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}" >
        <li>${temp}</li>
    </c:forEach>
</ul>

</body>
</html>
