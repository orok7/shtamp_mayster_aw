<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    <%@include file="../css/modal_recovery.css" %>
</style>

<div id="passrecovery_mb" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <span class="close" id="closePR">&times;</span>
            <h2>Відновити пароль</h2>
        </div>
        <div class="modal-body">
            <form action="/passRecovery" method="post">
                <br>&nbsp;Ваш E-mail<br><br>
                <input type="email" name="userEmail" placeholder="petro@domain.com"><br><br>
                <input type="submit" value="Надіслати тимчасовий пароль">
            </form>
        </div>
    </div>

</div>

<script>
    var passRecBlank = document.getElementById("passrecovery_mb");
    var btnPassRec = document.getElementById("passrecovery");
    var closePR = document.getElementById("closePR");
    btnPassRec.onclick = function() {
        passRecBlank.style.display = "block";
    }
    closePR.onclick = function() {
        passRecBlank.style.display = "none";
    }
    window.onclick = function(event) {
        if (event.target == passRecBlank) {
            passRecBlank.style.display = "none";
        }
    }
</script>
