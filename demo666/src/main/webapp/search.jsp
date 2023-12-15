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


    <c:if test="${phones != null}">
    <h1 style="font-size: 50px">Phone</h1>
    <span><a href="/phone_servlet"><button type="button" class="btn btn-primary"style="margin-top: 40px;margin-bottom: 15px">BACK TO LIST</button></a></span>
<%--    <span><input placeholder="Search by name" name="search" id="search" style="float: right;margin-top: 40px;margin-bottom: 20px"></span>--%>
    <table class="table">
        <tr>
            <td><b>#</b></td>
            <td><b>NAME</b></td>
            <td><b>PRICE</b></td>
            <td><b>CATEGORY</b></td>
            <td><b>ACTION</b></td>
        </tr>
        <c:forEach items="${phones}" var="p" varStatus="loop">
            <tr>
                <td>
                        ${loop.count}
                </td>
                <td>
                        ${p.getName()}
                </td>
                <td>
                        ${p.getPrice()}
                </td>

                <c:forEach items="${categories}" var="c">
                    <c:if test="${c.getId() == p.getCategory()}">
                        <td>
                                ${c.getName()}
                        </td>
                    </c:if>
                </c:forEach>

                <td>
                        <%--                btn edit--%>
                    <a href="/phone_servlet?action=edit&id=${p.id}">
                        <button type="button" class="btn btn-primary">Sửa</button>
                    </a>
                        <%--                button delete--%>
                    <button type="button" onclick="sendInfo('${p.id}','${p.name}')" class="btn btn-danger"
                            data-bs-toggle="modal" data-bs-target="#exampleModal">Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
<!-- Modal delete-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Are you sure?</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form method="post" action="/phone_servlet?action=delete">
                <div class="modal-body">
                    <input type="hidden" id="id" name="id">
                    Are you sure to delete <span id="name"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancle</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
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
    table {
        font-size: 20px;
    }
</style>
<script>
    function sendInfo(id, name) {
        document.getElementById("name").innerText = name;
        document.getElementById("id").value = id;
    }
</script>
</body>
</html>
