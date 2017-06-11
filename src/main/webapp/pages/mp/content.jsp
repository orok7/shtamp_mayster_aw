<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="../css/content.css" %>
    <%@include file="../css/block.css" %>
</style>
<div class="content contentbg mrg-btm fright border mrg-lft">
    <p class="content-title">${contentTitle}</p>
    <div class="table-div">
        <c:forEach items="${list}" var="elem">
            <div class="block">
                <p>${elem}</p>
            </div>
        </c:forEach>
    </div>
    <div class="page-select">
        <c:if test="${pageNum > 1}">
        <a href="/toFirstPage" title="На початок"><<&nbsp;&nbsp;</a>
        <a href="/prevPage" title="Назад"><-&nbsp;&nbsp;</a></c:if>
        &nbsp;&nbsp;${pageNum}&nbsp;&nbsp;
        <c:if test="${!lastPage}">
        <a href="/nextPage" title="Вперід">&nbsp;&nbsp;-></a>
        <a href="/toLastPage" title="В кінець">&nbsp;&nbsp;>></a></c:if>
    </div>
</div>