<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    <%@include file="../css/modal_registration.css" %>
</style>

<div id="registration_mb" class="modal" style="display: ${regModDisplay}">

    <div class="modal-content">
        <div class="modal-header">
            <span class="close" id="closeR">&times;</span>
            <h2>Реєстрація</h2>
        </div>
        <div class="modal-body">
            <form id="formReg" onsubmit="return regValidator(true, false)" action="/regIndividualUser" method="post">
                <br><input type="checkbox" name="isCompany" id="isCompany">
                Аккаунт для юридичної особи<br><br>
                <div id="individualData">
                    <input class="ui" type="text" name="userName" placeholder="Петро" required>
                    &nbsp;&nbsp;&nbsp;Ім'я<br><br>
                    <input class="ui" type="text" name="userSurname" placeholder="Петрів" required>
                    &nbsp;&nbsp;&nbsp;Прізвище<br><br>
                </div>
                <div id="companyData">
                    <input class="ui" type="text" name="userOwnership" placeholder="Приватне підприємство">
                    &nbsp;&nbsp;&nbsp;Форма власності<br><br>
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
                </div>
                <input type="email" name="userEmail" placeholder="petro@domain.com" required>
                &nbsp;&nbsp;&nbsp;E-mail<br><br>
                <input type="password" name="userPassword" placeholder="password" required>
                &nbsp;&nbsp;&nbsp;Пароль<br><br>
                <input type="password" name="userPassAgain" placeholder="password" required>
                &nbsp;&nbsp;&nbsp;Підтвердіть пароль<br>
                <br><input type="checkbox" id="isAccepted">
                Я приймаю <a href="#">умови</a> реєстрації<br><br>
                <input type="submit" value="Зареєструвати" disabled id="submitReg">
                <span id="MWWR" style="color: red"></span>
            </form>
        </div>
    </div>

</div>

<script>
    var regBlank = document.getElementById("registration_mb");
    var btnReg = document.getElementById("registration");
    var closeR = document.getElementById("closeR");
    btnReg.onclick = function() {
        regBlank.style.display = "block";
    }
    closeR.onclick = function() {
        regBlank.style.display = "none";
    }
    window.onclick = function(event) {
        if (event.target == regBlank) {
            regBlank.style.display = "none";
        }
    }
</script>

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

    function regValidator(firstRun, resOfFirstRun) {
        if (firstRun) {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.responseText === "true") {
                        regValidator(false, false);
                    } else regValidator(false, true);
                }
            };
            xhr.open("GET", "/findSameEmail?userEmail=" + document.getElementsByName("userEmail")[0].value, true);
            xhr.send(null);
        } else {
            if (!resOfFirstRun) {
                document.getElementById("MWWR").innerHTML = "Введений емейл вже зареєстровано"
                return false;
            }
            var pass = document.getElementsByName("userPassword")[0];
            var passAg = document.getElementsByName("userPassAgain")[0];
            if (pass.value === passAg.value) {
                document.getElementById("MWWR").innerHTML = "";
                document.forms["formReg"].submit();
                return true;
            }
            document.getElementById("MWWR").innerHTML = "Помилка підтвердження паролю";
            return false;
        } return false;
    }
</script>