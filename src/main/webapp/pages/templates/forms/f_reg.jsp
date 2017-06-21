<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sf:form id="formReg" class="form-horizontal" action="/user/regIndividualUser" method="post" modelAttribute="regUser">

    <sf:checkbox path="isCompany" class="form-control" id="urIsCompany"/>
    <label class="control-label col-sm-2" for="urIsCompany">Обліковий запис для юридичної особи</label>

    <div class="form-group" id="urIndividualData">
        <div class="form-group">
            <label class="control-label col-sm-2" for="urIName">Ім'я:</label>
            <div class="col-sm-10">
                <input id="urIName" type="text" name="urIName" placeholder="Петро" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="urISurname">Прізвище:</label>
            <div class="col-sm-10">
                <input id="urISurname" type="text" name="urISurname" placeholder="Петрів" required>
            </div>
        </div>
    </div>

    <div class="form-group" id="urCompanyData">
        <div class="form-group">
            <label class="control-label col-sm-2" for="urCOwnership">Форма власності:</label>
            <div class="col-sm-10">
                <input id="urCOwnership" type="text" name="urCOwnership" placeholder="Приватне підприємство" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="urCFullName">Назва:</label>
            <div class="col-sm-10">
                <input id="urCFullName" type="text" name="urCFullName" placeholder="Ваша назва" required>
            </div>
        </div>
    </div>
        <%--<div id="companyData">--%>
            <%--<input class="ui" type="text" name="userOwnership" placeholder="Приватне підприємство">--%>
            <%--&nbsp;&nbsp;&nbsp;Форма власності<br><br>--%>
            <input class="ui" type="text" name="userFullName" placeholder="Ваша назва">
            &nbsp;&nbsp;&nbsp;Назва<br><br>
            <input class="ui" type="text" name="userShortName" placeholder="ПП ВашаНаз">
            &nbsp;&nbsp;&nbsp;Скорочена назва<br><br>
            <input class="ui" type="text" name="userCode" placeholder="01234567">
            &nbsp;&nbsp;&nbsp;Код ЄДРПОУ<br><br>
            <input class="ui" type="text" name="userContactName" placeholder="Петро">
            &nbsp;&nbsp;&nbsp;Ім'я контактної особи<br><br>
            <input class="ui" type="text" name="userContactSurname" placeholder="Петрів">
            &nbsp;&nbsp;&nbsp;Прізвище контактної особи<br><br>
        <%--</div>--%>
        <input type="email" name="userEmail" placeholder="petro@domain.com" required>
        &nbsp;&nbsp;&nbsp;E-mail<br><br>
        <input type="password" name="userPassword" placeholder="password" required>
        &nbsp;&nbsp;&nbsp;Пароль<br><br>
        <input type="password" name="userPassAgain" placeholder="password" required>
        &nbsp;&nbsp;&nbsp;Підтвердіть пароль<br>
        <br><input type="checkbox" id="isAccepted">
        Я приймаю <a href="#">умови</a> реєстрації<br><br>
        <input type="submit" value="Зареєструвати" disabled id="submitReg">
    </form>












    <div class="form-group">
        <label class="control-label col-sm-2" for="urEmail">Email:</label>
        <div class="col-sm-10">
            <sf:input type="email" class="form-control" id="urEmail"
                      path="login" placeholder="Введіть Ваш Email"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" for="urPassword">Пароль:</label>
        <div class="col-sm-10">
            <sf:input type="password" class="form-control" id="urPassword"
                      path="password" placeholder="Введіть пароль"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success btn-block">Увійти</button>
            <span style="color: red"><sf:errors path="login"/></span>
            <hr style="margin-bottom: 0">
            <a href="/user/passrecovering"><button type="button" class="btn btn-link fleft" style="margin-right: 10px">Забули пароль?</button></a>
            <a href="/user/registration"><button type="button" class="btn btn-link fright">Зареєструватися</button></a>
        </div>
    </div>

</sf:form>

<script>
    function reloadAccepted() {
        if (isAccepted.checked) {
            isAccepted.checked = false;
            submitReg.disabled = false;
        } else {
            submitReg.disabled = true;
        }
    }
    reloadAccepted();
</script>

<script>
    var regIsCompany = document.getElementById('isCompany');
    var regIndividualData = document.getElementById('individualData');
    var regCompanyData = document.getElementById("companyData");
    regIsCompany.onclick = function () {
        if (regIsCompany.checked) {
            regIndividualData.style.display = "none";
            regCompanyData.style.display = "block";
            document.getElementById("formReg").action = "/regCompanyUser";
        } else {
            regIndividualData.style.display = "block";
            regCompanyData.style.display = "none";
            document.getElementById("formReg").action = "/regIndividualUser";
        }
        var ui = document.getElementsByClassName("ui");
        for (var i = 0; i < ui.length; i++){
            ui[i].required = !ui[i].required;
        }
    }
</script>

<script>
    var isAccepted = document.getElementById('isAccepted');
    var submitReg = document.getElementById('submitReg');
    isAccepted.onclick = function () {
        if (isAccepted.checked) {
            submitReg.disabled = false;
        } else {
            submitReg.disabled = true;
        }
    }
</script>