<%--
  Created by IntelliJ IDEA.
  User: bunbu
  Date: 11/27/2023
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete user</h1>
<p>
  <a href="/UserServlet">Back to user list</a>
</p>
<form method="post">
  <h3>Are you sure?</h3>
  <fieldset>
    <legend>Customer information</legend>
    <table>
      <tr>
        <td>ID: </td>
        <td>${user.id}</td>
      </tr>
      <tr>
        <td>Name: </td>
        <td>${user.name}</td>
      </tr>
      <tr>
        <td>Email: </td>
        <td>${user.email}</td>
      </tr>
      <tr>
        <td>Country: </td>
        <td>${user.country}</td>
      </tr>
      <tr>
        <td><input type="submit" value="Delete customer"></td>
        <td><a href="/UserServlet">Back to customer list</a></td>
      </tr>
    </table>
  </fieldset>
</body>
</html>
