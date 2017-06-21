<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="mb_passrec" class="my-modal" style="display: ${passRecModDisplay}">

    <div class="my-modal-content">

        <div class="my-modal-header">
            <span class="close" id="closePR">&times;</span>
            <h2>Відновлення паролю</h2>
        </div>

        <div class="my-modal-body">
            <%@include file="../forms/f_passrec.jsp" %>
        </div>

    </div>

</div>