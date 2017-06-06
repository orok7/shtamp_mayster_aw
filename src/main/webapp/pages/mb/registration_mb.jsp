<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    <%@include file="../css/modal_main.css" %>
</style>

<div id="registration_mb" class="modal">

    <div class="modal-content">
        <div class="modal-header">
            <span class="close">&times;</span>
            <h2>Реєстрація</h2>
        </div>
        <div class="modal-body">
            <form action="/registration" method="post">
                <br>Ім'я<br>
                <input type="text" name="userName"><br>
                <br>Прізвище<br>
                <input type="text" name="userSurname"><br>
                <br>E-mail<br>
                <input type="email" name="userEmail"><br>
                <br>Пароль<br>
                <input type="password" name="userPassword"><br>
                <br>Підтвердіть пароль<br>
                <input type="password" name="userPassAgain"><br><br>
                <input type="submit" value="Зареєструватися"><br><br>
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
