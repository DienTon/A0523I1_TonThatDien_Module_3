<%--
  Created by IntelliJ IDEA.
  User: bunbu
  Date: 11/30/2023
  Time: 12:20 AM
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
<h1 style="text-align: center; padding: 50px ">USER LIST</h1>
<div class="row">
    <p class="col-2">
        <a href="/UserServlet?action=create">
            <button type="button" class="btn btn-primary" style="width: 80%">Add new User</button>
        </a>
    </p>
    <p class="col-2">
        <a href="/UserServlet?action=sort">
            <button type="button" class="btn btn-primary" style="width: 80%">Sort by name</button>
        </a>
    </p>
    <form method="get" class="col-8" action="/UserServlet" onsubmit="return appendSearchCountry()">
        <input placeholder="Nhập country cần tìm" class="col-7" type="text" style="width: 80%" id="searchCountry" name="searchCountry">
        <input type="submit" value="Submit">
    </form>
</div>

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
</body>
<style>
    * {
        margin-bottom: 10px;
    }
</style>
</html>

