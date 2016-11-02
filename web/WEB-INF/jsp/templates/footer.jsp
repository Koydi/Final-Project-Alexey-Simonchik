<%@page pageEncoding="UTF-8"%>
        <div class="col-md-12">
            <div class="col-md-4 col-md-offset-4 footer-style">
                <p class="footer-text">
                    Epam Training Center
                </p>
                <p class="footer-text">
                    Minsk 2016
                </p>
            </div>
            <img alt="footer image" src="data/common/images/footer.png" class="img-responsive">
        </div>

        </div>

        <script src="jquery/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>

        <div class="modal" id="modal-signin">
            <div class="modal-dialog">
                <div class="modal-content modal-window-style">

                    <div class="modal-header modal-header-style">
                        <div class="modal-title">
                            <div class="col-md-5 h1">
                                Filmoteka
                            </div>
                            <div class="col-md-offset-4 col-md-3">
                                <img alt="sign in image" src="data/common/images/sign-in.png" class="img-responsive">
                            </div>
                        </div>
                    </div>

                    <div class="modal-body">
                        <form role="form" action="/sign_in" method="post">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name="email" id="email" placeholder="Введите ваш email">
                            </div>
                            <div class="form-group">
                                <label for="pass">Пароль</label>
                                <input type="password" class="form-control" id="pass" name="password" placeholder="Введите ваш пароль">
                            </div>
                            <button class="btn btn-default modal-button-style" type="submit" name="command" value="SIGN_IN">Войти</button>
                        </form>
                    </div>

                    <div class="modal-footer modal-footer-style">
                        <button class="btn btn-default modal-button-style" type="button" data-dismiss="modal">CANCEL</button>
                    </div>

                </div>
            </div>
        </div>


    </body>
</html>