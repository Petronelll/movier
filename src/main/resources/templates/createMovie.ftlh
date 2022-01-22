<#import "common.ftl" as c/>
<@c.page title="createMovie"></@c.page>
<main id="main">
    <div class="container">
        <form action="/movie/new" method="POST">
            <div class="form-group">
                <label for="title">Movie name</label>
                <input name="title" id="title"  class="form-control" required>
            </div>
            <div class="form-group">
                <label for="releaseYear">Release year</label>
                <input name="releaseYear" id="releaseYear" class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="duration">Duration in minutes</label>
                <input name="duration" id="duration" class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="imageUrl">Image Url</label>
                <input name="imageUrl" id="imageUrl" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea name="description" id="description" class="form-control" rows="16" required></textarea>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>
