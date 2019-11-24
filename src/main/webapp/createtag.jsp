<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html lang="ru">
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<br>

<form class="form-horizontal" action="do?command=CreateTag" method="post" enctype="multipart/form-data">
<fieldset>

<!-- Form Name -->
<legend>Создание нового элемента вашей коллекции</legend>
<br>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-5 control-label" for="trademark list"><em>Список торговых марок</em></label>
  <div class="col-md-5">
    <select id="trademark list" name="trademark list" class="form-control">
      <option></option>
        <c:forEach items="${trademarks}" var="trademark">
            <option value="${trademark.trademark}">${trademark.trademark}</option>
        </c:forEach>
    </select>
    <span class="help-block">если нужного нет - оставьте поле пустым</span>
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-5 control-label" for="trademark"></label>
  <div class="col-md-5">
  <input id="trademark" name="trademark" type="text" class="form-control input-md">
  <span class="help-block">введите торговую марку</span>
  </div>
</div>
<br>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-5 control-label" for="subtitle"><em>Подзаголовок</em></label>
  <div class="col-md-5">
  <input id="subtitle" name="subtitle" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">что еще написано на ярлычке?<br>Можно использовать английские буквы и пробелы</span>
  </div>
</div>
<br>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-5 control-label" for="material"><em>Материал</em></label>
  <div class="col-md-5">
    <select id="material" name="material" class="form-control">
      <option value="cardboard">картон</option>
      <option value="paper">бумага</option>
      <option value="plastic">пластик</option>
    </select>
  </div>
</div>
<br>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-5 control-label" for="width"><em>Ширина, мм</em></label>
  <div class="col-md-5">
  <input id="width" name="width" type="text" class="form-control input-md">
  </div>
</div>
<br>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-5 control-label" for="height"><em>Высота, мм</em></label>
  <div class="col-md-5">
  <input id="height" name="height" type="text" class="form-control input-md">
  </div>
</div>
<br>
<!-- Date input-->
<div class="form-group">
  <label class="col-md-5 control-label" for="in collection"><em>В коллекции с</em></label>
  <div class="col-md-5">
  <input id="in collection" name="in collection" type="text" class="form-control input-md">
    <span class="help-block">Дата в формате ГГГГ-ММ-ДД</span>
  </div>
</div>
<br>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-5 control-label" for="number in catalog"><em>Номер в каталоге</em></label>
  <div class="col-md-5">
  <input id="number in catalog" name="number in catalog" type="text" class="form-control input-md">
  <span class="help-block">состоит из 3-х блоков цифр, разделенных дефисом;<br>
  1-й блок - типоразмер (две цифры):<br>
   <strong>01</strong> - если ширина до 23 мм, а высота до 25 мм,<br>
   <strong>02</strong> - если ширина до 32 мм, а высота до 35 мм;<br>
  2-й блок - номер ряда в реестре (до трех цифр);<br>
  3-й блок - столбец в ряду (одна цифра).</span>
  </div>
</div>
<br>
<!-- File Button -->
<div class="form-group">
  <label class="col-md-5 control-label" for="upload"><em>Изображение</em></label>
  <div class="col-md-5">
    <input id="upload" name="upload" class="input-file" type="file">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="create"></label>
  <div class="col-md-4">
    <button id="create" name="create" class="btn btn-primary">Создать</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>