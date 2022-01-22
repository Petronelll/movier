<#import "common.ftl" as c/>
<@c.page title="admin"></@c.page>
<main id="main">
    <div class="container">
        <h2>Delete movie</h2>
        <form action="/admin/deleteMovie" method="POST">
            <div class="form-group">
                <label for="id">Movie id</label>
                <input name="id" id="id"  class="form-control" type="number" required>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
        <h2>Delete actor</h2>
        <form action="/admin/deleteActor" method="POST">
            <div class="form-group">
                <label for="id">Actor id</label>
                <input name="id" id="id"  class="form-control" type="number" required>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
        <h2>Update movie title</h2>
        <form action="/admin/updateMovieTitle" method="POST">
            <div class="form-group">
                <label for="id">Movie id</label>
                <input name="id" id="id"  class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="title">Movie title</label>
                <input name="title" id="title"  class="form-control"  required>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
        <h2>Update actor name</h2>
        <form action="/admin/updateActorName" method="POST">
            <div class="form-group">
                <label for="id">Actor id</label>
                <input name="id" id="id"  class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="name">Actor name</label>
                <input name="name" id="name"  class="form-control"  required>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
        <a href="/movie/new">Insert new movie</a>
        <br>
        <a href="/actor/new">Insert new actor</a>
    </div>
</main>
</body>
</html>
