<%--
  Created by IntelliJ IDEA.
  User: JetFree
  Date: 07.05.2020
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Customer list</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manger</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
            <form:form action="search" method="get">
                Search customer: <input type="text" name="theSearchName">
                <input type="submit" value="Search" class="add-button" />
                <input type="button" value="Reset results" onclick="window.location.href='list'; return false;" class="add-button">
            </form:form>


            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="tempCustomer" items="${customers}">
                    <!-- construct an "update" link with customer id
                    var - it's name of variable, value - url to send request
                    param - parameter in URL
                    -->
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>

                    <!-- loop over and print our customers -->
                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <!-- our link with parameter (customer id) -->
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}" onclick="return confirm('Are you sure you want to delete this customer?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
