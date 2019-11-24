<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html lang="ru">
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<br>

<h4>Редактирование пользователей</h4>
<br>
<div class="row">
        <div class=col-md-3>Логин</div>
        <div class=col-md-4>Email</div>
        <div class=col-md-2>Роль</div>
    </div>
    <c:forEach items="${AllUsers}" var="user">
        <form class="form-horizontal-${user.id}" action="do?command=EditUsers" method="post">
            <div class="row">
                    <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${user.id}">

                <div class="col-md-3">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.login}">
                </div>

                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.email}">
                </div>

                <div class="col-md-2">
                     <select id="role_id" name="role_id" class="form-control">
                           <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" ${user.role_id==role.id?"selected":""}>${role.role}</option>
                           </c:forEach>
                     </select>
                </div>

                <!-- Button (Double) -->
                <div class="col-md-3">
                    <button id="delete" name="delete" class="btn btn-danger">Удалить</button>
                    <button id="update" name="update" class="btn btn-success">Обновить</button>
                </div>
            </div>
        </form>
    </c:forEach>

</div>
</body>
</html>