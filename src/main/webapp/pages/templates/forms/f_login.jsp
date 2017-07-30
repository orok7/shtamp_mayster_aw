<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form name='loginForm' class="form-horizontal" action="/login" method="post">

    <div class="form-group">
        <label class="control-label col-sm-2" for="uliEmail">Email:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="uliEmail"
                   name="username" placeholder="Введіть Ваш Email"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" for="uliPassword">Пароль:</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="uliPassword"
                   name="password" placeholder="Введіть пароль"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success btn-block">Увійти</button>
            <div style="margin-top: 15px">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="alert alert-info">${msg}</div>
                </c:if>
            </div>
            <hr style="margin-bottom: 0">
            <button id="pasreg_btn" type="button" class="btn btn-link fleft" style="margin-right: 10px">Забули пароль?
            </button>
            <button id="regFL_btn" type="button" class="btn btn-link fright">Зареєструватися</button>
        </div>
    </div>

    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>

</form>
