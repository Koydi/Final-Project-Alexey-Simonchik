<%--
  Created by IntelliJ IDEA.
  User: koydi
  Date: 11/2/16
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp"%>

<div class="col-md-10 col-md-offset-1 main-style">

    <c:set var="filmInfo" value="${requestScope.film}" />
    <!--Картинка и краткие сведениея о фильме-->
    <div class="col-md-10 col-md-offset-1">

        <!--Картинка-->
        <div class="col-md-4" style="height: 100%;">
            <h2>${filmInfo.name}</h2>
            <img alt="cover" src="${filmInfo.image}" class="img-responsive img-rounded">
        </div>

        <!--Год выпуска-->
        <div class="col-md-7 col-md-offset-1">

            <div class="col-md-12 information-border-style" id="first-information-block">
                <div class="col-md-6">
                    <p class="lead info-type">
                        Год выпуска :
                    </p>
                </div>
                <div class="col-md-6">
                    <p class="lead">
                        ${filmInfo.releaseDate}
                    </p>
                </div>
            </div>

            <!--Страна-->
            <div class="col-md-12 information-border-style">
                <div class="col-md-6">
                    <p class="lead info-type">
                        Страна :
                    </p>
                </div>
                <div class="col-md-6">
                    <p class="lead">
                        ${filmInfo.country}
                    </p>
                </div>
            </div>

            <!--Режиссер-->
            <div class="col-md-12 information-border-style">
                <div class="col-md-6">
                    <p class="lead info-type">
                        Режиссер :
                    </p>
                </div>
                <div class="col-md-6">
                    <p class="lead">
                        ${filmInfo.producer}
                    </p>
                </div>
            </div>

            <!--Бюджет-->
            <div class="col-md-12 information-border-style">
                <div class="col-md-6">
                    <p class="lead info-type">
                        Бюджет :
                    </p>
                </div>
                <div class="col-md-6">
                    <p class="lead">
                        $ ${filmInfo.budget}
                    </p>
                </div>
            </div>

            <!--Сборы-->
            <div class="col-md-12 information-border-style">
                <div class="col-md-6">
                    <p class="lead info-type">
                        Сборы :
                    </p>
                </div>
                <div class="col-md-6">
                    <p class="lead">
                        $ ${filmInfo.boxOffice}
                    </p>
                </div>
            </div>

            <!--Возрастное ограничение-->
            <div class="col-md-12 information-border-style">
                <div class="col-md-6">
                    <p class="lead info-type">
                        Возрастное ограничение :
                    </p>
                </div>
                <div class="col-md-6">
                    <p class="lead">
                        ${filmInfo.ageRestriction.minimalAge}+
                    </p>
                </div>
            </div>

        </div>

    </div>

    <!--Описание фильма-->
    <div class="col-md-10 col-md-offset-1 description-style">
        <p class="lead" id="film-description">
            ${filmInfo.description}
        </p>
    </div>

    <!--Оценка фильма-->
    <div class="col-md-10 col-md-offset-1 mark-wrapper">
        <div class="col-md-7">
            <p class="lead">
                <i>Средняя оценка пользователей : </i><i id="mark-style">${filmInfo.averageMark}</i>
            </p>
        </div>
        <div class="col-md-6">
            <div class="mark-bar">
                <div class="mark-status" style="width: ${filmInfo.averageMark * 10}%;">
                </div>
            </div>
        </div>
    </div>

    <!--Трейлер фильма-->
    <div class="col-md-6 col-md-offset-3 trailer-class">
        <video width="100%" height="100%" controls class="embed-responsive-item">
            <source src="${filmInfo.trailer}" type="video/mp4">
            Your browser does not support the video tag.
        </video>
    </div>

<%@include file="templates/footer.jsp"%>