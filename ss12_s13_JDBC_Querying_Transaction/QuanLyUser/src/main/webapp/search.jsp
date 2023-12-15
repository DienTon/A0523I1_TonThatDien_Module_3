<%--
  Created by IntelliJ IDEA.
  User: bunbu
  Date: 12/1/2023
  Time: 6:18 PM
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
<h1 style="text-align: center; padding: 50px ">USER LIST BY COUNTRY</h1>
    <p>
        <a href="/UserServlet">
            <button type="button" class="btn btn-primary">Return User List</button>
        </a>
    </p>

<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${list}" var="c" varStatus="loop">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.country}</td>
            <td><a href="/UserServlet?action=edit&id=${c.getId()}">Edit</a></td>
            <td><a href="/UserServlet?action=delete&id=${c.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<c:if test="${message != null}">
    <h2 class="message" style="text-align: center; color: red">${message}</h2>
</c:if>
</body>
<style>
    * {
        margin-bottom: 10px;
    }
</style>
</body>
</html>
