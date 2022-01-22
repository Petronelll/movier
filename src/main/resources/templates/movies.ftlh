<#import "common.ftl" as c/>
<@c.page title="movies"></@c.page>
<main id="main">
    <div class="container">
        <#list movies as movie>
            <a href="/movie/${movie.id}">${movie.title}</a>
            <br>
        </#list>
    </div>
</main>
</body>
</html>
