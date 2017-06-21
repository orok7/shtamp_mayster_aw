<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sf:form class="form-horizontal" action="/user/passrecovery" method="post" modelAttribute="passrecUser">

    <div class="form-group">
        <label class="control-label col-sm-2" for="prEmail">Ваш E-mail:</label>
        <div class="col-sm-10">
            <sf:input type="email" class="form-control" id="prEmail"
                      path="login" placeholder="Введіть Ваш Email"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success btn-block">Надіслати тимчасовий пароль</button>
            <span style="color: red"><sf:errors path="login"/></span>
            <hr style="margin-bottom: 0">
            <a href="/user/registration"><button type="button" class="btn btn-link fright">Зареєструватися</button></a>
        </div>
    </div>

</sf:form>