<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/modal_recovery.css">

<div id="passrecovery_mb" class="modal" style="display: ${passRecModDisplay}">
    <div class="modal-content">
        <div class="modal-header">
            <span class="close" id="closePR">&times;</span>
            <h2>Відновити пароль</h2>
        </div>
        <div class="modal-body">
            <form id="formPassRec" action="/passRecovery" onsubmit="return passRecValidator(true, false)" method="post">
                <br>&nbsp;Ваш E-mail<br><br>
                <input type="email" name="userEmailForRecovery" placeholder="petro@domain.com"><br><br>
                <input type="submit" value="Надіслати тимчасовий пароль">
                <span id="MWWPR" style="color: red"></span>
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

<script>
    function passRecValidator(firstRun, resOfFirstRun) {
        if (firstRun) {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.responseText === "false") {
                        passRecValidator(false, false);
                    } else passRecValidator(false, true);
                }
            };
            xhr.open("GET", "/findSameEmail?userEmail=" + document.getElementsByName("userEmailForRecovery")[0].value, true);
            xhr.send(null);
        } else {
            if (!resOfFirstRun) {
                document.getElementById("MWWPR").innerHTML = "Введений емейл не знайдено"
                return false;
            } else {
                document.getElementById("MWWPR").innerHTML = "";
                document.forms["formPassRec"].submit();
                return true;
            }
        } return false;
    }
</script>
