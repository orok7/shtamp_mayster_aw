<%@include file="templates/main_parts/head.jsp" %>

<div class="container">
    <h1>Welcome to Admin Page</h1>
    <a href="/admin/logout">Close admin session</a>
</div>
<hr>
<br>
<div class="container">
    <form class="form-horizontal" action="/admin/buildForm" method="post">

        <div class="form-group">

            <label class="control-label col-md-2" for="admPageSelect">Select table:</label>

            <div class="col-md-3">
                <select class="form-control" name="listEntities" id="admPageSelect">
                    <c:forEach items="${apEntitiesList}" var="entity">
                        <option value="${entity}">${entity}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">Build form</button>
            </div>

            <div class="col-md-4">
                <h2 style="margin: 0">${entityName}</h2>
            </div>

        </div>

    </form>
</div>

<c:if test="${showBuildedForm}">
    <%@include file="templates/forms/f_entityAddData.jsp" %>
</c:if>

</body>
</html>
