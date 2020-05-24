<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <strong>Авторизация</strong>
    <@l.login "/login" />
    <a href="/registration">Зарегистрироваться</a>
</@c.page>