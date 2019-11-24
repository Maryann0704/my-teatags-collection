<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html lang="ru">
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<br>

<p>Вы действительно хотите выйти?</p>
<br>

<form class="form-horizontal" action="do?command=logout" method="post">
<fieldset>

    <!-- Button -->
        <div class="form-group">
            <div class="col-md-3">
               <button id="logout" name="logout" class="btn btn-danger">Выйти</button>
               <button id="no" name="no" class="btn btn-success">Остаться</button>
            </div>
         </div>

</fieldset>

</div>
</body>
</html>
