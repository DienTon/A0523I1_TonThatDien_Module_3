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
  <a href="/UserServlet">Back to customer list</a>
</p>
<form method="post">
  <fieldset>
    <legend>user information</legend>
    <table>
      <tr>
        <td>id: </td>
        <td><p id="id" name = "id">${user.getId()}</p></td>
      </tr>
      <tr>
        <td>Name: </td>
        <td><input type="text" name="name" id="name" value="${user.getName()}"></td>
      </tr>
      <tr>
        <td>Email: </td>
        <td><input type="text" name="email" id="email" value="${user.getEmail()}"></td>
      </tr>
      <tr>
        <td>Country: </td>
        <td><input type="text" name="country" id="country" value="${user.getCountry()}"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Update user"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
