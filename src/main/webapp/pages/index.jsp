<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/user/registration"></a>

<%@include file="templates/modal_boxes/mb_reg.jsp" %>
<%@include file="templates/modal_boxes/mb_passrec.jsp" %>

<script src="/my_js/my_modal.js"></script>
<script>
    my_modal("mb_logining","closeUL");
    my_modal("mb_logouting","closeULO");
    my_modal("mb_passrec","closePR");
    my_modal("mb_reg","closeReg");
</script>

</body>
</html>
