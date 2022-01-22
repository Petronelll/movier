<#import "common.ftl" as c/>
<@c.page title="createActor"></@c.page>
<main id="main">
    <div class="container">
    <form action="/actor/new" method="POST">
        <div class="form-group">
            <label for="name">Actor name</label>
            <input name="name" id="name"  class="form-control" required>
        </div>
        <div class="form-group">
            <label for="imageUrl">Image Url</label>
            <input name="imageUrl" id="imageUrl" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="biography">Biography</label>
            <textarea name="biography" id="biography" rows="24" class="form-control" required></textarea>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
    </div>
</main>
</body>
</html>