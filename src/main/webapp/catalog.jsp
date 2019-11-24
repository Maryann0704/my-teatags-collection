<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html lang="ru">
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<br>
<h4>Все ярлычки на сайте</h4>
<br>

<div class="row">
        <div class="col-md-2 text-center">Картинка</div>
        <div class="col-md-1 text-center">Торговая марка</div>
        <div class="col-md-2 text-center">Подзаголовок</div>
        <div class="col-md-2 text-center">Размер, мм х мм</div>
        <div class="col-md-2 text-center">В коллекции с</div>
        <div class="col-md-1 text-center">Номер в каталоге</div>
        <div class="col-md-1 text-center">Имя пользователя</div>
    </div>
<hr>
    <c:forEach items="${teatags}" var="teatag">
        <div class="row">
            <div class="col-md-2"><img src="pictures/${teatag.numInCatalog}.jpg" height="70 px" alt="${teatag.numInCatalog}"></div>
            <div class="col-md-1">${teatag.trademark}</div>
            <div class="col-md-2">${teatag.subtitle}</div>
            <div class="col-md-2 text-center">${teatag.width} х ${teatag.height}</div>
            <div class="col-md-2 text-center">${teatag.inCollectionSince}</div>
            <div class="col-md-1">${teatag.numInCatalog}</div>
            <div class="col-md-1 text-center">${teatag.userName}</div>
        </div>
        <hr>
    </c:forEach>
    <br>
    <my:paginator count="${teatagsSize}" step="10" urlprefix="do?command=catalog&start="/>
    <br>
</div>
</body>
</html>