
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CreateActor</title>
</head>
<body>
<main id="main">
    <form action="http://localhost:8089/api/register" method="POST">
        <div>
            <label for="name">Actor name</label>
            <input name="name" id="name" required>
        </div>
        <div>
            <label for="imageUrl">Image Url</label>
            <input name="imageUrl" id="imageUrl" required>
        </div>
        <div>
            <label for="biography">Biography</label>
            <textarea name="biography" id="biography" rows="40" cols = "80" required></textarea>
        </div>
        <div>
            <button>Submit</button>
        </div>
    </form>
</main>
</body>
</html>