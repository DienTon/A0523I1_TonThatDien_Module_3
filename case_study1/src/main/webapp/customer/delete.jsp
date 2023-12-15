<%--
  Created by IntelliJ IDEA.
  User: bunbu
  Date: 11/27/2023
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete user</h1>
<p>
    <a href="/customer-servlet">Back to Customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>

                <td>ID:</td>
                <td>${customer.id}</td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${customer.name}</td>
            </tr>
            <tr>
                <td>Date:</td>
                <td>${customer.birthDay}</td>
            </tr>
            <tr>
                <td>Gender:</td>
                <c:if test="${customer.gender == 1}">
                    <td>Nam</td>
                </c:if>
                <c:if test="${customer.gender == 0}">
                    <td>Nữ</td>
                </c:if>
            </tr>
            <tr>
                <td>Id_Card</td>
                <td>${customer.id_card}</td>
            </tr>
            <tr>
                <td>Phone</td>
                <td>${customer.phone}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${customer.email}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${customer.address}</td>
            </tr>
            <tr>
                <td>Type</td>
                <c:forEach var="t" items="${customerTypeList}">

                    <c:if test="${t.customerTypeId == customer.idCustomerType}">
                        <td>${t.customerTypeName}</td>
                    </c:if>

                </c:forEach>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
