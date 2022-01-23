<#import "common.ftl" as c/>
<@c.page title="actors"></@c.page>
<main id="main">
    <div class="container">
        <#list actors as actor>
            <a href="/actor/${actor.id}">${actor.name}</a>
            <br>
        </#list>
    </div>
</main>
</body>
</html>
