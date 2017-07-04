<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/modal_registration.css">


<form id="formReg" class="form-horizontal" action="/user/regIndividualUser" method="post">

    <div class="checkbox">
        <label><input type="checkbox" name="urIsCompany" id="urIsCompany">
            Обліковий запис для юридичної особи
        </label>
    </div>

    <hr>

    <%-- Company Data --%>

    <div class="form-group" id="urCompanyData">

        <div class="form-group">
            <label class="control-label col-sm-4" for="urCOwnership">Форма власності:</label>
            <div class="col-sm-7">
                <input class="form-control uData" id="urCOwnership" type="text" name="urCOwnership" placeholder="Приватне підприємство">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4" for="urCFullName">Назва:</label>
            <div class="col-sm-7">
                <input class="form-control uData" id="urCFullName" type="text" name="urCFullName" placeholder="Ваша назва">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4" for="urCShortName">Скорочена назва:</label>
            <div class="col-sm-7">
                <input class="form-control uData" id="urCShortName" type="text" name="urCShortName" placeholder="ПП ВашаНаз">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4" for="urCCode">Код ЄДРПОУ:</label>
            <div class="col-sm-7">
                <input class="form-control uData" id="urCCode" type="text" name="urCCode" placeholder="01234567">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4" for="urCContactName">Ім'я контактної особи:</label>
            <div class="col-sm-7">
                <input class="form-control uData" id="urCContactName" type="text" name="urCContactName" placeholder="Петро">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4" for="urCContactSurname">Прізвище контактної особи:</label>
            <div class="col-sm-7">
                <input class="form-control uData" id="urCContactSurname" type="text" name="urCContactSurname" placeholder="Петрів">
            </div>
        </div>

    </div>

    <%--Main Data--%>

    <div class="form-group">
        <label class="control-label col-sm-4" for="urIName">Ім'я:</label>
        <div class="col-sm-7">
            <input class="form-control uData" id="urIName" type="text" name="urIName" placeholder="Петро" required>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" for="urISurname">Прізвище:</label>
        <div class="col-sm-7">
            <input class="form-control uData" id="urISurname" type="text" name="urISurname" placeholder="Петрів" required>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" for="urEmail">Email:</label>
        <div class="col-sm-7">
            <input type="email" class="form-control" id="urEmail" placeholder="Введіть Ваш Email"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" for="urPassword">Пароль:</label>
        <div class="col-sm-7">
            <input type="password" class="form-control" id="urPassword" placeholder="password"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" for="urPasswordAg">Підтвердіть пароль:</label>
        <div class="col-sm-7">
            <input type="password" class="form-control" id="urPasswordAg" placeholder="password"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-7">
            <button type="submit" class="btn btn-success btn-block">Зареєструвати</button>
        </div>
    </div>

</form>



<script>
    function reloadAccepted() {
        if (isAccepted.checked) {
            isAccepted.checked = false;
            submitReg.disabled = false;
        } else {
            submitReg.disabled = true;
        }
    }
    console.log("reloadAccepted()");
    reloadAccepted();
</script>

<script>
    console.log("2()");
    var regIsCompany = document.getElementById('urIsCompany');
    var regIndividualData = document.getElementById('urIndividualData');
    var regCompanyData = document.getElementById("urCompanyData");
    regIsCompany.onclick = function () {
        console.log("regIsCompany.onclick");
        if (regIsCompany.checked) {
            regIndividualData.style.display = "none";
            regCompanyData.style.display = "block";
            document.getElementById("formReg").action = "/user/regCompanyUser";
        } else {
            regIndividualData.style.display = "block";
            regCompanyData.style.display = "none";
            document.getElementById("formReg").action = "/user/regIndividualUser";
        }
        var uData = document.getElementsByClassName("uData");
        for (var i = 0; i < uData.length; i++){
            uData[i].required = !uData[i].required;
        }
    }
</script>

<script>
    console.log("3");
    var isAccepted = document.getElementById('isAccepted');
    var submitReg = document.getElementById('submitReg');
    isAccepted.onclick = function () {
        console.log("isAccepted.onclick");
        if (isAccepted.checked) {
            submitReg.disabled = false;
        } else {
            submitReg.disabled = true;
        }
    }
</script>