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
        <h4>Genre: ${movie.genre.name}</h4>
        <h4>Description: ${movie.description}</h4>
        <h4>Top Cast: </h4>
        <ul>
            <#list movie.movieCharacters as character>
            <li><a href="/actor/${character.actor.id}">${character.actor.name}</a> as ${character.characterName}</li>
            </#list>
        </ul>
        <h4>Reviews: </h4>
        <ul>
            <#list movie.movieReviews as review>
                <li>Username: ${review.user.username}. Rating: ${review.rating}. ${review.text}</li>
            </#list>
        </ul>

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
