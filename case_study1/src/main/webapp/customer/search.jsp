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


    <c:if test="${customer != null}">
        <h1 style="text-align: center; padding: 50px ">CUSTOMER</h1>
        <p>
            <a href="/customer-servlet">
                <button type="button" class="btn btn-primary">Return Customer List</button>
            </a>
        </p>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Name</th>
                <th scope="col">Date</th>
                <th scope="col">Gender</th>
                <th scope="col">id Card</th>
                <th scope="col">Phone</th>
                <th scope="col">Email</th>
                <th scope="col">Address</th>
                <th scope="col">Type</th>
                <th scope="col">Action</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customer}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>${c.birthDay}</td>

                    <c:if test="${c.gender eq 1}">
                        <td style="text-align: center">Nam</td>
                    </c:if>
                    <c:if test="${c.gender eq 0}">
                        <td style="text-align: center">Nữ</td>
                    </c:if>

                    <td>${c.id_card}</td>
                    <td>${c.phone}</td>
                    <td>${c.email}</td>
                    <td>${c.address}</td>
                    <c:forEach var="type" items="${customerTypeList}">
                        <c:if test="${type.customerTypeId == customer.idCustomerType}">
                            <td>${type.customerTypeName}
                            </td>
                        </c:if>
                    </c:forEach>

                    <td><a href="/customer-servlet?action=edit&id=${c.getId()}">
                        <button type="button" class="btn btn-primary">Edit</button>
                    </a></td>
                    <td><a href="/customer-servlet?action=delete&id=${c.getId()}">
                        <button type="button" class="btn btn-primary">Delete</button>
                    </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

<c:if test="${message != null}">
    <h1 class="message" style="text-align: center; color: red" id="error">${message}</h1>
</c:if>
</body>
<style>
    * {
        margin-bottom: 10px;
    }
    #error{
        padding: 20%;
    }
</style>
</body>
</html>
