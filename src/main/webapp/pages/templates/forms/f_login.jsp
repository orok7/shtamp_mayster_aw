<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sf:form class="form-horizontal" action="/user/login" method="post" modelAttribute="loggedUser">

    <div class="form-group">
        <label class="control-label col-sm-2" for="uliEmail">Email:</label>
        <div class="col-sm-10">
            <sf:input type="email" class="form-control" id="uliEmail"
                   path="login" placeholder="Введіть Ваш Email"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" for="uliPassword">Пароль:</label>
        <div class="col-sm-10">
            <sf:input type="password" class="form-control" id="uliPassword"
                      path="password" placeholder="Введіть пароль"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success btn-block">Увійти</button>
            <span style="color: red"><sf:errors path="login"/></span>
            <hr style="margin-bottom: 0">
            <a href="/user/passrecovery"><button type="button" class="btn btn-link fleft" style="margin-right: 10px">Забули пароль?</button></a>
            <a href="/user/registration"><button type="button" class="btn btn-link fright">Зареєструватися</button></a>
        </div>
    </div>

</sf:form>
