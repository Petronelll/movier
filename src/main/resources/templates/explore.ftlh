<#import "common.ftl" as c/>
<@c.page title="explore"></@c.page>
<main id="main">
    <div class="container">
        <h3>Find movies by genre</h3>
        <form action="/movie/search" method="GET">
            <div class="form-group">
                <label for="genre">Search movie by genre</label>
                <input name="genre" id="genre" class="form-control" required>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
        <div class="card" style="width: 30rem;">
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <a href="/movie/mostReviewed">Most reviewed movies</a>
                </li>
                <li class="list-group-item">
                    <a href="/movie/longest">Longest movies</a>
                </li>
                <li class="list-group-item">
                    <a href="/movie/highestRated">Highest rated movies</a>
                </li>
                <li class="list-group-item">
                    <a href="/movie/oldest">Oldest movies</a>
                </li>
                <li class="list-group-item">
                    <a href="/movie/inAnyWatchlist">Movies in any watchlist</a>
                </li>
                <li class="list-group-item">
                    <a href="/movie/withoutReviews">Movies without reviews</a>
                </li>
            </ul>
        </div>
    </div>
</main>
</body>
</html>
