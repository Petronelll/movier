<#import "common.ftl" as c/>
<@c.page title="actor"></@c.page>
<main id="main">
    <div class="container">
        <div class="text-center">
            <h1>${actor.name}</h1>
            <img src="${actor.imageUrl}" alt="actor photo" class="img-fluid">
            <br><br>
            <h3>Biography</h3>
            <p>${actor.biography}</p>
        </div>
    </div>
</main>
</body>
</html>
