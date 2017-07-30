<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/header.css">

<div class="myheader border headerbg">

    <div class="col-md-offset-2 col-md-7 tableHeader">
        <div class="row">
            <div class="col-md-3">м.Львів, вул.Дорошенка, 14</div>
            <div class="col-md-3">тел.: <a href="tel:+380676957889">(067) 695 7889</a></div>
            <div class="col-md-2"><a href="tel:+380633741895">(063) 374 1895</a></div>
            <div class="col-md-4"><a href="mailto:info@pechatka.lviv.ua?subject=Запитання відвідувача сайту">
                e-mail: info@pechatka.lviv.ua</a></div>
        </div>
        <div class="row">
            <div class="col-md-3">м.Львів, вул.Куліша, 34</div>
            <div class="col-md-3">тел.: <a href="tel:+380980439141">(098) 043 9141</a></div>
            <div class="col-md-2"><a href="tel:+380635068283">(063) 506 8283</a></div>
            <div class="col-md-4"><a href="mailto:info2@pechatka.lviv.ua?subject=Запитання відвідувача сайту">
                e-mail: info2@pechatka.lviv.ua</a></div>
        </div>
        <form class="search_form" action="/search" title="Пошук">
            <div class="form-group col-md-9">
                <input class="form-control btn-block" type="search" name="searchThis" placeholder="Пошук...">
            </div>
            <div class="form-group col-md-2">
                <button class="btn btn-success btn-block mrg-l10" type="submit">Пошук</button>
            </div>
        </form>

    </div>

    <div class="mycart col-md-1">
        <a href="" style="display: block; width: 100%; height: 100%" title="Корзина"></a>
    </div>

    <div class="col-md-2">

        <div class="myuser col-md-4 fleft">
            <a href="/user/profile" style="display: block; width: 100%; height: 100%" title="Обліковий запис"></a>
        </div>

        <div class="col-md-7 fright mrg-t10"
             style="height: 103px;">

            <div style="width: 96%;height: 46%;/*margin: 2%*/">
                <button id='login_btn' class="btn btn-success btn-block">Вхід</button>
            </div>

            <div style="width: 96%;height: 46%;/*margin: 2%*/">
                <button id='reg_btn' class="btn btn-success btn-block">Реєстрація</button>
            </div>

        </div>

    </div>

</div>

<div class="mylogo">
    <a href="/" style="display: block; width: 100%; height: 100%" title="На головну"></a>
</div>

<script>

</script>