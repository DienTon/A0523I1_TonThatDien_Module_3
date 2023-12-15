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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center;">ADD NEW PHONE</h1>

<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <form method="post" id="myForm">
<%--            name--%>
            <div class="mb-3">
                <label class="form-label">Name Phone</label>
                <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp">
            </div>
<%--            price--%>
            <div class="mb-3">
                <label class="form-label">Price</label>
                <input type="number" class="form-control" id="price" name="price">
            </div>
<%--            category            --%>
            <div class="mb-3">
                <label class="form-label">Category</label>
                <select class="form-select" aria-label="Default select example" id="category" name="category">
                    <option selected value="null">Select category</option>
                    <c:forEach var="c" items="${categories}">--%>
                        <option value="${c.getId()}">${c.getName()}</option>
                    </c:forEach>
                </select>
            </div>
<%--    action--%>
            <button type="submit" class="btn btn-primary" id="submitBtn">Submit</button>
            <span>
                <a href="/phone_servlet">
                    <button type="button" class="btn btn-primary">Back to list</button>
                </a>
                <c:if test='${requestScope["message"] != null}'>
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </span>
        </form>
    </div>
    <div class="col-3"></div>
</div>
</body>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var form = document.getElementById('myForm');
        var nameInput = document.getElementById('name'); // Thay 'name' bằng ID thực tế của ô input
        var priceInput = document.getElementById('price'); // Thay 'price' bằng ID thực tế của ô input
        var categorySelect = document.getElementById('category'); // Thay 'category' bằng ID thực tế của ô input

        form.addEventListener('submit', function (event) {
            if (nameInput.value.trim() === '' || priceInput.value.trim() === '' || categorySelect.value === 'null') {
                // Ngăn chặn việc submit nếu có ít nhất một trường không có dữ liệu
                event.preventDefault();
                alert('Please fill in all fields before submitting.');
            }
        });
    });
</script>
</html>
