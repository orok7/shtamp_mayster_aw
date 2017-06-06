<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    <%@include file="../css/modal_main.css" %>
    <%@include file="../css/modal_registration.css" %>
</style>

<div id="registration_mb" class="modal">

    <div class="modal-content">
        <div class="modal-header">
            <span class="close">&times;</span>
            <h2>Реєстрація</h2>
        </div>
        <div class="modal-body">
            <form action="/registration" method="post">
                <br><input type="checkbox" id="isCompany">
                Аккаунт для юридичної особи<br><br>
                <div id="individualData">
                    <input type="text" name="userName" placeholder="Петро">
                    &nbsp;&nbsp;&nbsp;Ім'я<br><br>
                    <input type="text" name="userSurname" placeholder="Петрів">
                    &nbsp;&nbsp;&nbsp;Прізвище<br><br>
                    <input type="email" name="userEmail" placeholder="petro@domain.com">
                    &nbsp;&nbsp;&nbsp;E-mail<br><br>
                    <input type="password" name="userPassword" placeholder="password">
                    &nbsp;&nbsp;&nbsp;Пароль<br><br>
                    <input type="password" name="userPassAgain" placeholder="password">
                    &nbsp;&nbsp;&nbsp;Підтвердіть пароль
                </div>
                <div id="companyData">
                    <input type="text" name="userForm" placeholder="Приватне підприємство">
                    &nbsp;&nbsp;&nbsp;Форма власності<br><br>
                    <input type="text" name="userFullName" placeholder="Якась назва">
                    &nbsp;&nbsp;&nbsp;Назва<br><br>
                    <input type="text" name="userShortName" placeholder="ПП ЯкНаз">
                    &nbsp;&nbsp;&nbsp;Скорочена назва<br><br>
                    <input type="text" name="userContactName" placeholder="Петро">
                    &nbsp;&nbsp;&nbsp;Ім'я контактної особи<br><br>
                    <input type="text" name="userContactSurname" placeholder="Петрів">
                    &nbsp;&nbsp;&nbsp;Прізвище контактної особи<br><br>
                    <input type="email" name="userEmail" placeholder="petro@domain.com">
                    &nbsp;&nbsp;&nbsp;E-mail<br><br>
                    <input type="password" name="userPassword" placeholder="password">
                    &nbsp;&nbsp;&nbsp;Пароль<br><br>
                    <input type="password" name="userPassAgain" placeholder="password">
                    &nbsp;&nbsp;&nbsp;Підтвердіть пароль
                </div><br>
                <br><input type="checkbox" id="isAccepted">
                Я приймаю <a href="#">умови</a> реєстрації<br><br>
                <input type="submit" value="Зареєструвати" disabled id="submitReg">
            </form>
        </div>
    </div>

</div>

<script>
    var modal = document.getElementById('registration_mb');
    var btn = document.getElementById("registration");
    var span = document.getElementsByClassName("close")[0];
    btn.onclick = function() {
        modal.style.display = "block";
    }
    span.onclick = function() {
        modal.style.display = "none";
    }
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
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
