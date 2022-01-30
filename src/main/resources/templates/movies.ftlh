<#import "common.ftl" as c/>
<@c.page title="movies"></@c.page>
<main id="main">
    <div class="album py-5 bg-light">
        <div class="container">

            <#list movies as movie>
            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4 box-shadow">
                        <img class="card-img-top" src="${movie.imageUrl}" alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text"><a href="/movie/${movie.id}">${movie.title}</a></p>
                        </div>
                    </div>
                </div>
            </div>
            </#list>
        </div>
    </div>
</main>
</body>
</html>
