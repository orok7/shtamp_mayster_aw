<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    <%@include file="../css/header.css" %>
</style>
<div class="logo">
    <a href="" style="display: block; width: 100%; height: 100%" title="На головну"></a>
</div>

<header class="border headerbg">
    <div style="float: left">
        <table>
            <tr>
                <td>м. Львів, вул. Дорошенка, 14</td>
                <td>тел.: <a href="tel:+380676957889">(067) 695 7889</a></td>
                <td><a href="tel:+380633741895">(063) 374 1895</a></td>
                <td><a href="mailto:info@pechatka.lviv.ua?subject=Запитання відвідувача сайту">
                    e-mail: info@pechatka.lviv.ua</a></td>
            </tr>
            <tr>
                <td>м. Львів, вул. Куліша, 34</td>
                <td>тел.: <a href="tel:+380980439141">(098) 043 9141</a></td>
                <td><a href="tel:+380635068283">(063) 506 8283</a></td>
                <td><a href="mailto:info2@pechatka.lviv.ua?subject=Запитання відвідувача сайту">
                    e-mail: info2@pechatka.lviv.ua</a></td>
            </tr>
        </table>
        <form class="search_form" action="/search" title="Пошук">
            <input class="width80 height100" type="search" name="searchThis" placeholder="Пошук...">
            <input class="width20 height100" type="submit" value="Пошук">
        </form>
    </div>
    <div class="cart">
        <a href="" style="display: block; width: 100%; height: 100%" title="Корзина"></a>
    </div>
    <form class="login_form" action="/login" title="Увійти в свій акаунт" method="post" style="display: ${loginDisplay}">
        E-mail:<br>
        <input class="width100" type="email" name="loginName" placeholder="email@domain.com">
        <br>Пароль:<br>
        <input class="width80" type="password" name="pass" placeholder="password">
        <input class="width20" type="submit" value="Вхід">
        <a href="#" id="passrecovery" style="float: left" title="Відновити пароль">Забули пароль?</a>
        <a href="#" id="registration" style="float: right" title="Зареєструвати акаунт">Зареєструватися</a>
    </form>
    <div class="logged_div" style="display:
        <c:choose>
            <c:when test="${not empty loggedDisplay}">
                ${loggedDisplay}
            </c:when>
            <c:otherwise>
                none
            </c:otherwise>
        </c:choose>">
        Welcome ${luName}
        <br><br>
        <form action="/logout" method="post">
            <input type="submit" value="Вихід">
        </form>
    </div>
</header>