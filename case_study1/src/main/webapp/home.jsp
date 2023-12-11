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
                <a href="/customer-servlet">Customer</a>
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
                    <input type="text" style="width: 400px;" placeholder="Search" name="search" id="search">
                </form>
        </span>
        </ul>
    </div>
</header>

<body>
<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="4000">
            <img src="https://img.tripi.vn/cdn-cgi/image/width=1280/https://storage.googleapis.com/hms_prod/photo/thumb/461953MTj/1.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item" data-bs-interval="2000">
            <img src="https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2020/06/Review-Furama-Resort-Da-Nang-13.jpg" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://phulong.com/imgvtool.ashx?url=/UploadFiles/image_contents/1200-x-700-toan-canh-01-01-7a1dc1.png&w=1200" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
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