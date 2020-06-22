<%--
  Created by IntelliJ IDEA.
  User: jetfree
  Date: 2020-05-18
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Save Customer</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manger</h2>
    </div>
</div>
<div id="container">
    <h3>Save Customer</h3>
    <!-- [IMPORTANT: modelAttribute="customer"] - this means that form try to call customer.getFirstName() and so on
     to try to pre-populate the form -->
    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <!-- need to associate this data with customer id by adding hidden form with customer id -->
        <form:hidden path="id" />
        <table>
            <tbody>
            <tr>
                <td><label>First Name:</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last Name:</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear;both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
    </p>
</div>
</body>
</html>
