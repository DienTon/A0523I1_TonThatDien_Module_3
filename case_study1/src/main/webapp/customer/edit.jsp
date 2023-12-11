<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bunbu
  Date: 11/27/2023
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/customer-servlet">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>user information</legend>
        <table>
                <td><input type="hidden" name="id" id="id" value="${customer.getId()}"></td></tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" value="${customer.getName()}"></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type="date" name="date" id="date" value="${customer.getBirthDay()}" oninput="validateDate()" onclick="validateDate()"></td>
                <td id="error" style="padding-left: 30px; color: indigo"></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <select class="form-select" name="gender" id="gender">
                        <c:if test="${customer.getGender() == 1}">
                            <option value="1">Nam</option>
                            <option value="0">Nữ</option>
                        </c:if>
                        <c:if test="${customer.getGender() == 0}">
                            <option value="0">Nữ</option>
                            <option value="1">Nam</option>
                        </c:if>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Id_Card</td>
                <td><input type="text" name="id_card" id="id_card" value="${customer.getId_card()}"></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone" id="phone" value="${customer.getPhone()}"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email" value="${customer.getEmail()}"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" id="address" value="${customer.getAddress()}"></td>
            </tr>
            <tr>
                <td>Type</td>
                <td>
                    <select class="form-select" name="type" id="type">

                        <c:forEach var="c" items="${customerTypeList}">
                            <c:if test="${c.customerTypeId == customer.idCustomerType}">
                                <option value="${c.customerTypeId}">${c.customerTypeName}</option>
                            </c:if>
                        </c:forEach>

                        <c:forEach var="c" items="${customerTypeList}">
                            <c:if test="${c.customerTypeId != customer.idCustomerType}">
                                <option value="${c.customerTypeId}">${c.customerTypeName}</option>
                            </c:if>
                        </c:forEach>

                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
<script>

</script>
</body>
</html>
