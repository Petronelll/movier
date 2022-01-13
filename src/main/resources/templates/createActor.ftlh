
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="icon" type="image/png" href="../static/images/favicon.ico"/>

    <title>CreateActor</title>
</head>

<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="/">
                <img src="/images/logo.png" alt="movier" width="150" height="36">
            </a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">

                <div class="navbar-nav">
                    <a class="nav-link" href="/">Home</a>
                    <a class="nav-link" href="#">Movies</a>
                    <a class="nav-link" href="#">Actors</a>
                    <a class="nav-link" href="#">Search</a>
                </div>


                <div class="col align-self-end"></div>
                <div class="navbar-nav">
                    <a class="nav-link" href="">Watchlist</a>
                    <a class="nav-link" href="#">Account</a>
                </div>
            </div>
        </div>
    </nav>
</header>
<main id="main">
    <div class="container">
    <form action="http://localhost:8089/api/register" method="POST">
        <div class="form-group">
            <label for="name">Actor name</label>
            <input name="name" id="name"  class="form-control" required>
        </div>
        <div class="form-group">
            <label for="imageUrl">Image Url</label>
            <input name="imageUrl" id="imageUrl" type="email" class="form-control" required>
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