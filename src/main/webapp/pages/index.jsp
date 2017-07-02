<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="templates/main_parts/head.jsp" %>

    <%@include file="templates/main_parts/header.jsp" %>
    <%@include file="templates/main_parts/menu.jsp" %>
<sec:authorize access="isAuthenticated()">
    <h1>hello!</h1>
</sec:authorize>
<form action="/login" method="post" <%--modelAttribute="loggedUser"--%>>
    <input type="text" name="username" <%--path="username"--%>/>
    <input type="password" name="password" <%--path="password"--%>/>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input type="submit"/>
</form>
    <%@include file="templates/main_parts/content.jsp" %>
    <%@include file="templates/main_parts/footer.jsp" %>
    <%--<%@include file="templates/modal_boxes/mb_logining.jsp" %>--%>
    <%@include file="templates/modal_boxes/mb_logouting.jsp" %>
    <%@include file="templates/modal_boxes/mb_reg.jsp" %>
    <%@include file="templates/modal_boxes/mb_passrec.jsp" %>

    <script src="/my_js/my_modal.js"></script>
    <script>
        my_modal("mb_logining","closeUL");
        my_modal("mb_logouting","closeULO");
        my_modal("mb_passrec","closePR");
        my_modal("mb_reg","closeReg");
    </script>
    <%--<script>--%>
        <%--if ("${msgPlaceInIndex}" !== "")--%>
            <%--alert("${msgPlaceInIndex}");--%>
    <%--</script>--%>

</body>
</html>
