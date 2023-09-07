<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru" data-bs-theme="light" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Аренда авто</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"></c:url>">

    <!--FAVICONS-->
    <link rel="apple-touch-icon" sizes="180x180" href="<c:url value="/resources/images/apple-touch-icon.png"></c:url>">
    <link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/resources/images/favicon-32x32.png"></c:url>">
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/resources/images/favicon-16x16.png"></c:url>">
    <link rel="manifest" href="<c:url value="/resources/webmanifest/site.webmanifest"></c:url>">


</head>
<body>


<div class="container">
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills justify-content-center">
            <li class="nav-item">
                <a href="/admin/requests" class="nav-link bg-primary rounded-pill text-white">Новые заявки</a>
            </li>
            <li class="nav-item">
                <a href="/admin/active-requests" class="nav-link bg-primary rounded-pill text-white">Активные заявки</a>
            </li>
            <li class="nav-item">
                <a href="/admin/end-of-requests" class="nav-link bg-primary rounded-pill text-white">Подтверждение окончания заявки</a>
            </li>
        </ul>
    </header>
</div>


<c:forEach var="request" items="${activeRequests}">
    <hr class="featurette-divider">
    <div class="row featurette justify-content-center d-flex flex-column justify-content-between mb-3" align="center">
        <div class="col-md-12 order-md-2" align="center">
            <h2 class="featurette-heading fw-normal lh-1">Заказ №${request.id}</h2>
            <p class="lead">
                Заказчик: ${request.client.name} ${request.client.surname},
                выбранная машина: ${request.car.brand} ${request.car.model},
                время аренды: ${request.hours} ч., цена аренды: ${request.price} р.
            </p>
        </div>
    </div>
</c:forEach>

<!-- FOOTER-->
<footer>
    <div class="container">
        <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
            <div class="col-md-4 d-flex align-items-center">
                <a href="/" class="mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1">
                    <img class="bi" width="30" height="24"
                         src="<c:url value="/resources/images/favicon-32x32.png"></c:url> ">
                </a>
                <span class="mb-3 mb-md-0 text-body-secondary">© 2023 Company, Inc</span>
            </div>
        </footer>
    </div>
</footer>
</body>
</html>