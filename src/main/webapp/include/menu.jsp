<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="d-flex justify-content-around" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                 <a class="nav-link" href=".">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=Catalog">Каталог</a>
            </li>
            <c:if test="${user!=null}">
            <li class="nav-item">
                 <a class="nav-link" href="do?command=Profile">Профиль</a>
            </li>
            <li class="nav-item">
                 <a class="nav-link" href="do?command=EditUsers">Админка</a>
            </li>
            <li class="nav-item">
                 <a class="nav-link" href="do?command=ResetDataBase">Сброс базы</a>
            </li>
            </c:if>
            <c:if test="${user==null}">
            <li class="nav-item">
            <a class="nav-link" href="do?command=Login">Авторизация</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=SignUp">Регистрация</a>
            </li>
            </c:if>
            <c:if test="${user!=null}">
            <li class="nav-item">
                 <a class="nav-link" href="do?command=Logout">Выход</a>
            </li>
            </c:if>
        </ul>
    </div>
</nav>