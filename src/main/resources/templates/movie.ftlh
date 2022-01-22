<#import "common.ftl" as c/>
<@c.page title="movie"></@c.page>
<main id="main">
    <div class="container">
        <div class="text-center">
            <h1>${movie.title}</h1>
            <img src="${movie.imageUrl}" alt="movie photo" class="img-fluid">
        </div>
        <h4>Release year: ${movie.releaseYear}</h4>
        <h4>Duration in minutes: ${movie.duration}</h4>
        <h4>Description: ${movie.description}</h4>

        <form action="/watchlist" method="POST">
            <div class="form-group">
                <input name="id" id="id" type="hidden"  class="form-control" value="${movie.id}" required>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Add to watchlist</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>
