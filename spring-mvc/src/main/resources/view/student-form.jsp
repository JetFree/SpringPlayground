<%--
  Created by IntelliJ IDEA.
  User: jetfree
  Date: 2020-03-23
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student registration form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First Name: <form:input path="firstName"/>
    <br><br>
    Last Name: <form:input path="lastName"/>
    <br><br>
    <form:select path="country">
        <form:options items="${theCountryOptions}"/>
    </form:select>
    <br><br>
    Favorite languages:
    <div style="margin-left: 40px;">
        <br><br>
        Java<form:radiobutton path="favoriteLanguage" value="Java"/>
        <br><br>
        C# <form:radiobutton path="favoriteLanguage" value="C#"/>
        <br><br>
        JavaScript <form:radiobutton path="favoriteLanguage" value="JavaScript"/>
        <br><br>
        Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
    </div>
    <br>
    <hr style="width: 200px" align="left">
    Operating systems:
    <div style="margin-left: 40px;">
        <br><br>
        Linux <form:checkbox path="operatingSystems" value="Linux"/>
        <br><br>
        MacOS <form:checkbox path="operatingSystems" value="MacOS"/>
        <br><br>
        Windows <form:checkbox path="operatingSystems" value="Windows"/>
    </div>
    <br>
    <hr style="width: 200px" align="left">
    <br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
