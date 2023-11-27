<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bunbu
  Date: 11/25/2023
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<table class="table">
  <thead>
  <h1>Danh Sách Khách Hàng</h1>
  <tr>
    <th><b>Tên</b></th>
    <th><b>Ngày sinh</b></th>
    <th><b>Địa chỉ</b></th>
    <th><b>Ảnh</b></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="kh" varStatus="loop">
    <tr>
      <td>${kh.tenKh}</td>
      <td>${kh.ngaySinh}</td>
      <td>${kh.diaChi}</td>
      <td><img src="${kh.anh}" style="width: 70px;height: 70px"></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
