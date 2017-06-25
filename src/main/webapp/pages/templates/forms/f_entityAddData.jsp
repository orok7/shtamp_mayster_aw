<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="form-horizontal" action="/admin/saveSome${entityName}" method="post">

    <c:set var="efI" value="${0}"/>
    <c:forEach items="${entityFields}" var="entityField">
        
        <div class="form-group">
            <label class="control-label col-sm-4" for="efInput${efI = efI + 1}">${entityField.fieldName}:</label>
            <div class="col-sm-7">
                
                <c:choose>

                    <c:when test="${entityField.inputType == 'multi-select'}">

                        <select class="form-control" multiple = "multiple">
                            <c:forEach items="${entityField.fieldObjectValue}" var="objectVal">
                                <option value="${objectVal.id}">${objectVal}</option>
                            </c:forEach>
                        </select>

                    </c:when>

                    <c:when test="${entityField.inputType == 'select'}">

                        <select class="form-control">
                            <c:forEach items="${entityField.fieldObjectValue}" var="objectVal">
                                <option value="${objectVal.id}">${objectVal}</option>
                            </c:forEach>
                        </select>

                    </c:when>

                    <c:otherwise>

                        <input type="${entityField.inputType}" class="form-control" id="efInput${efI}"
                                  placeholder="${entityField.fieldName}"/>

                    </c:otherwise>

                </c:choose>

            </div>
        </div>

    </c:forEach>

    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-7">
            <button type="submit" class="btn btn-success btn-block">Add</button>
        </div>
    </div>

</form>