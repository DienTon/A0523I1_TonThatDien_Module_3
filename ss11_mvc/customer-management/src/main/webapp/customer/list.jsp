<%--
  Created by IntelliJ IDEA.
  User: bunbu
  Date: 11/27/2023
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center;">CUSTOMER LIST</h1>
<p>
    <a href="/customers?action=create">
        <button type="button" class="btn btn-primary">Add new Customer</button>
    </a>
</p>
<table class="table">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${customerList}" var="c" varStatus="loop">
        <tr>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.address}</td>
            <td><a href="/customers?action=edit&id=${c.getId()}">Edit</a></td>
            <td><a href="/customers?action=delete&id=${c.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
<style>
    * {
        margin-bottom: 10px;
    }
</style>
</html>
