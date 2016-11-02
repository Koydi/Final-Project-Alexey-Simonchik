<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Films</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <div id="carousel" class="carousel slide">

        <!--Индикаторы слайдов-->
        <ol class="carousel-indicators">
            <li class="active" data-target="#carousel" data-slide="0"></li>
            <li data-target="#carousel" data-slide="1"></li>
            <li data-target="#carousel" data-slide="2"></li>
        </ol>

        <!--Слайды-->
        <div class="carousel-inner">
            <!--Первый слайд-->
            <div class="item active">
                <img alt="first slide" src="data/common/images/first-slide-image.jpg">
                <div class="carousel-caption">
                    <h1>Filmoteka - это</h1>
                </div>
            </div>

            <!--Второй слайд-->
            <div class="item">
                <img alt="second slide" src="data/common/images/second-slide-image.jpg">
                <div class="carousel-caption">
                    <h1>Лучшее кино</h1>
                </div>
            </div>

            <!--Третий слайд-->
            <div class="item">
                <img alt="third slide" src="data/common/images/third-slide-image.jpg">
                <div class="carousel-caption">
                    <h1>Только новинки</h1>
                </div>
            </div>
        </div>

        <!--Стрелки переключения-->
        <a href="#carousel" class="left carousel-control" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a href="#carousel" class="right carousel-control" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>

    <div class="navbar navbar-inverse">

        <!--Кнопка раскрытия-->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-menu">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Filmoteka</a>
        </div>

        <!--Меню-->
        <div class="collapse navbar-collapse navbar-inverse" id="main-menu">
            <ul class="nav navbar-nav">
                <li><a href="film_list.html">Список фильмов</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:set var="userName" value="${sessionScope.user}" />
                <c:if test="${empty userName}">
                    <li><a href="#" data-toggle="modal" data-target="#modal-signin">Войти</a></li>
                    <li><a href="/registration?command=GO_TO_REGISTRATION">Зарегестрироваться</a></li>
                </c:if>
                <c:if test="${not empty userName}">
                    <li>${userName}</li>
                    <li><a href="/sign_out?command=SIGN_OUT">Выйти</a></li>
                </c:if>
                <li>
                    <!--Поиск-->
                    <form class="navbar-form" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search" name="">
                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </li>
            </ul>
        </div>
    </div>