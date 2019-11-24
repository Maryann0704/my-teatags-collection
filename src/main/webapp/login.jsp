<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<form class="form-horizontal" action="do?command=Login" method="post">
<fieldset>

<!-- Form Name -->
<legend>Авторизация пользователя</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Логин</label>
  <div class="col-md-5">
  <input id="login" name="login" value="admin" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">английские буквы, цифры, . и _, длина от 5 до 15</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-5">
    <input id="password" name="password" value="admin" type="password" placeholder="" class="form-control input-md" required="">
      <span class="help-block">английские буквы и цифры, длина от 5 до 15 символов</span>
      </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="login"></label>
  <div class="col-md-4">
    <button id="login" name="login" class="btn btn-primary">Войти</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>

