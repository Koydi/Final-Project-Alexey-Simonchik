<%--
  Created by IntelliJ IDEA.
  User: koydi
  Date: 11/2/16
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp"%>
<div class="col-md-10 col-md-offset-1 registration-style">
    <div class="col-md-4 col-md-offset-4 h1" style="text-align: center;">
        Регистрация
    </div>
    <div class="col-md-4 col-md-offset-4">
        <form role="form" action="/registration" method="post">
            <input type="hidden" name="command" value="REGISTRATION">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Введите ваш email">
            </div>
            <div class="form-group">
                <label for="pass">Пароль</label>
                <input type="password" class="form-control" id="pass" name="password" placeholder="Введите пароль">
            </div>
            <div class="form-group">
                <label for="pass">Потверждение пароля</label>
                <input type="password" class="form-control" id="pass" placeholder="Введите пароль еще раз">
            </div>
            <button class="btn btn-default registration-button" type="submit">Зарегестрироваться</button>
        </form>
    </div>

</div>
<%@include file="templates/footer.jsp"%>
