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
            <form action="/registration" method="post">
                <br><input type="checkbox" name="isCompany" id="isCompany">
                Аккаунт для юридичної особи<br><br>
                <div id="individualData">
                    <input type="text" name="userName" placeholder="Петро" value="${userName}">
                    &nbsp;&nbsp;&nbsp;Ім'я<br><br>
                    <input type="text" name="userSurname" placeholder="Петрів" value="${userSurname}">
                    &nbsp;&nbsp;&nbsp;Прізвище<br><br>
                </div>
                <div id="companyData">
                    <input type="text" name="userForm" placeholder="Приватне підприємство" value="${userForm}">
                    &nbsp;&nbsp;&nbsp;Форма власності<br><br>
                    <input type="text" name="userFullName" placeholder="Ваша назва" value="${userFullName}">
                    &nbsp;&nbsp;&nbsp;Назва<br><br>
                    <input type="text" name="userShortName" placeholder="ПП ВашаНаз" value="${userShortName}">
                    &nbsp;&nbsp;&nbsp;Скорочена назва<br><br>
                    <input type="text" name="userCode" placeholder="01234567" value="${userCode}">
                    &nbsp;&nbsp;&nbsp;Код ЄДРПОУ<br><br>
                    <input type="text" name="userContactName" placeholder="Петро" value="${userContactName}">
                    &nbsp;&nbsp;&nbsp;Ім'я контактної особи<br><br>
                    <input type="text" name="userContactSurname" placeholder="Петрів" value="${userContactSurname}">
                    &nbsp;&nbsp;&nbsp;Прізвище контактної особи<br><br>
                </div>
                <input type="email" name="userEmail" placeholder="petro@domain.com" value="${userEmail}">
                &nbsp;&nbsp;&nbsp;E-mail<br><br>
                <input type="password" name="userPassword" placeholder="password">
                &nbsp;&nbsp;&nbsp;Пароль<br><br>
                <input type="password" name="userPassAgain" placeholder="password">
                &nbsp;&nbsp;&nbsp;Підтвердіть пароль<br>
                <br><input type="checkbox" id="isAccepted">
                Я приймаю <a href="#">умови</a> реєстрації<br><br>
                <input type="submit" value="Зареєструвати" disabled id="submitReg">
                <span style="color: red">${msgWWR}</span>
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
    var isCompany = document.getElementById('isCompany');
    var individualData = document.getElementById('individualData');
    var companyData = document.getElementById("companyData");
    isCompany.onclick = function () {
        if (isCompany.checked) {
            individualData.style.display = "none";
            companyData.style.display = "block";
        } else {
            individualData.style.display = "block";
            companyData.style.display = "none";
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