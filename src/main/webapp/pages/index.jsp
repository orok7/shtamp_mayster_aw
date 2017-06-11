<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>${title}</title>
    <style>
        <%@include file="css/mp.css" %>
        <%@include file="css/modal_main.css" %>
    </style>
</head>
<body class="bodybg">
    <%@include file="mp/header.jsp" %>
    <%@include file="mp/menu.jsp" %>
    <%@include file="mp/content.jsp" %>
    <%@include file="mp/footer.jsp" %>
    <%@include file="mb/registration_mb.jsp" %>
    <%@include file="mb/passrecovery_mb.jsp" %>

    <script>
        if ("${msgPlaceInIndex}" !== "")
            alert("${msgPlaceInIndex}");
    </script>
</body>
</html>
