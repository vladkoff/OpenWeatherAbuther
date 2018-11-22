<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light" style="display: flex; justify-content: space-around">
    <a class="navbar-brand" href="/">OWA</a>


    <div>

        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
    </div>
</nav>