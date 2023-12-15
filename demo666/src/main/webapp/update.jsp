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
<h1 style="text-align: center;">UPDATE NEW PHONE</h1>

<div class="row">
  <div class="col-3"></div>
  <div class="col-6">
    <form method="post" id="myForm">
      <input id="id" name="id" type="hidden" value="${phone.id}">
      <%--            name--%>
      <div class="mb-3">
        <label class="form-label">Name Phone</label>
        <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp" value="${phone.name}">
      </div>
      <%--            price--%>
      <div class="mb-3">
        <label class="form-label">Price</label>
        <input type="number" class="form-control" id="price" name="price" value="${phone.price}" step="any">
      </div>
      <%--            category            --%>
      <div class="mb-3">
        <label class="form-label">Category</label>
        <select class="form-select" aria-label="Default select example" id="category" name="category">
          <c:forEach var="c" items="${categories}">
            <c:if test="${phone.getCategory() == c.getId()}">
              <option value="${c.getId()}">${c.getName()}</option>
            </c:if>
          </c:forEach>

          <c:forEach var="c" items="${categories}">
            <c:if test="${phone.getCategory() != c.getId()}">
              <option value="${c.getId()}">${c.getName()}</option>
            </c:if>
          </c:forEach>

        </select>
      </div>
      <%--    action--%>
      <button type="submit" class="btn btn-primary" id="submitBtn">Update</button>
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

</html>
