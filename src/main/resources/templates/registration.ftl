<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <strong>Зарегистрироваться</strong>
<#--    ${message}-->
    <@l.login "/registration" />
    <a href="login">Вернуться на страницу авторизации</a>
</@c.page>