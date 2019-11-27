<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html lang="ru">
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<br>

<h4>Мои данные</h4>

    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend></legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин</label>
                <div class="row">
                    <div class="col-md-5">
                        <input id="login" name="login" value="${user.login}" type="text" class="form-control">
                        <span class="help-block">английские буквы, цифры, . и _, длина от 5 до 15</span>
                    </div>
                    <div>
                         <button id="updateLogin" name="updateLogin" class="btn btn-success">Изменить</button>
                    </div>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль</label>
                <div class="row">
                    <div class="col-md-5">
                        <input id="password" name="password" value="${user.password}" type="password" class="form-control">
                        <span class="help-block">длина 5 до 15 символов</span>
                    </div>
                    <div>
                        <button id="updatePass" name="updatePass" class="btn btn-success">Изменить</button>
                    </div>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Электронная почта</label>
                <div class="row">
                    <div class="col-md-5">
                        <input id="email" name="email" value="${user.email}" type="text" class="form-control">
                        <span class="help-block">Ваш e-mail</span>
                    </div>
                    <div>
                        <button id="updateMail" name="updateMail" class="btn btn-success">Изменить</button>
                    </div>
                </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <div class="col-md-10">
                    <button id="deleteAc" name="deleteAc" class="btn btn-danger">Удалить аккаунт</button>
                    <button id="createTag" name="createTag" class="btn btn-primary">Добавить в коллекцию</button>
                </div>
            </div>

        </fieldset>
    </form>

<h3>Коллекция</h3>

<div class="row">
        <div class="col-md-2 text-center">Картинка</div>
        <div class="col-md-2 text-center">Торговая марка</div>
        <div class="col-md-2 text-center">Текст</div>
        <div class="col-md-2 text-center">Размер, мм х мм</div>
        <div class="col-md-2 text-center">Дата получения</div>
        <div class="col-md-1 text-center">Номер в каталоге</div>
        <div class="col-md-1 text-center">Удалить</div>
    </div>
<hr>
    <c:forEach items="${userTeatags}" var="teatag">
    <form class="form-horizontal-${teatag.id}" action="do?command=Profile" method="post">
        <div class="row">
            <div class="col-md-2"><img src="pictures/${teatag.numInCatalog}.jpg" height="70 px" alt="${teatag.numInCatalog}"></div>
            <div class="col-md-2">${teatag.trademark}</div>
            <div class="col-md-2">${teatag.subtitle}</div>
            <div class="col-md-2 text-center">${teatag.width} х ${teatag.height}</div>
            <div class="col-md-2 text-center">${teatag.inCollectionSince}</div>
            <div class="col-md-1">${teatag.numInCatalog}</div>
            <div class="col-md-1">
                <button id="deleteTag" name="deleteTag" class="btn btn-danger" value="${teatag.id}">X</button>
            </div>
        </div>
        <hr>
    </form>
    </c:forEach>
    <br>

</div>
</body>
</html>