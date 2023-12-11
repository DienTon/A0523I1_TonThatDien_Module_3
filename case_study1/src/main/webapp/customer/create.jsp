<%--
  Created by IntelliJ IDEA.
  User: bunbu
  Date: 11/27/2023
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center;">ADD NEW CUSTOMER</h1>
<p>
    <a href="/customer-servlet">
        <button type="button" class="btn btn-primary">Back to list</button>
    </a>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type="date" name="date" id="date"></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <select class="form-select" name="gender" id="gender">
                        <option value="0">Nữ</option>
                        <option value="1">Nam</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Id_Card</td>
                <td><input type="text" name="id_card" id="id_card"></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone" id="phone"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td>Type</td>
                <td>
                    <select class="form-select" name="type" id="type">
                        <c:forEach var="c" items="${customerTypeList}">
                            <option value="${c.customerTypeId}">${c.customerTypeName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create user"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
