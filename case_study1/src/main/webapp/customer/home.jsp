<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%--    <link rel="stylesheet" href="style.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Case Study</title>
</head>

<header>
    <div>
        <span>
            <img src="https://i.pinimg.com/474x/b2/57/81/b2578191becd55a7ebbc3aa9cfda9a7a.jpg"
                 style="height: 70px; width: 70px; padding: 10px;">
            
        </span>
        <span style="float: right; padding: 10px; padding-top: 20px;">
            <b>Tôn Thất Diễn</b>
        </span>
    </div>

    <br>

    <div id="menu">
        <ul>
            <li style="padding-left: 250px;">
                <a href="">Home</a>
            </li>
            <li>
                <a href="">Employee</a>
            </li>
            <li>
                <b>Customer</b>
            </li>
            <li>
                <a href="">Service</a>
            </li>
            <li>
                <a href="">Contract</a>
            </li>
            <span>
                <form>
                    <input name="action" type="hidden" id="action" value="search">
                    <input type="text" style="width: 400px;" placeholder="Search by name" name="searchByName" id="searchByName">
                </form>
        </span>
        </ul>
    </div>
</header>

<body>
<div id="content" class="row">
    <div id="actionMenu" class="col-1">
        <a href="/customer-servlet?action=create">
            <button type="button" class="btn btn-primary">ADD NEW CUSTOMER</button>
        </a>
    </div>
    <div id="right_content" class="col-11">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
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
            <c:forEach items="${customers}" var="c" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
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
                        <c:if test="${type.customerTypeId == c.idCustomerType}">
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
    </div>
</div>
</body>

<footer>
    <p>footer</p>
</footer>

<style>
    * {
        padding: 0;
        margin: 0;
    }

    .row {
        padding: 0px;
    }

    #menu ul {
        margin: 10px;
    }

    #menu li {
        text-align: center;
        float: left;
        margin-right: 100px;
        list-style-type: none;
    }

    li a {
        color: black;
        text-decoration: none;
    }

    #menu {
        border-top: 2px solid black;
        border-bottom: 2px solid black;
    }

    #actionMenu {
        border: 0;
        height: 400px;
        margin-top: 60px;
    }

    footer {
        border: 2px solid black;
    }

    #right_content table {
        margin-top: 20px;
    }

    #right_content {
        border-left: 2px solid black;
    }
</style>
</html>