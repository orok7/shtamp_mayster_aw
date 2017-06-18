<%@include file="templates/main_parts/head.jsp" %>

    <%@include file="templates/main_parts/header.jsp" %>
    <%@include file="templates/main_parts/menu.jsp" %>
    <%@include file="templates/main_parts/content.jsp" %>
    <%@include file="templates/main_parts/footer.jsp" %>
    <%@include file="templates/modal_boxes/mb_logining.jsp" %>
    <%@include file="templates/modal_boxes/mb_logouting.jsp" %>

    <script src="/my_js/my_modal.js"></script>
    <script>
        my_modal("mb_logining","closeUL");
        my_modal("mb_logouting","closeULO");
    </script>
    <%--<script>--%>
        <%--if ("${msgPlaceInIndex}" !== "")--%>
            <%--alert("${msgPlaceInIndex}");--%>
    <%--</script>--%>

</body>
</html>
