package movier.movie;

import movier.user.User;
import movier.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("movie")
public class MovieController {

    MovieService movieService;
    UserService userService;

    @Autowired
    public MovieController(MovieService movieService, UserService userService) {
        this.movieService = movieService;
        this.userService = userService;
    }


    @GetMapping(path = "/{id}", produces = "text/html")
    public String getMovie(@PathVariable Integer id, Model model) {
        Movie movie = movieService.findMovieById(id);
        if (movie == null) {
            model.addAttribute("reason", "Movie not found");
            return "error";
        }
        model.addAttribute(movie);
        return "movie";
    }

    @GetMapping(path = "/all", produces = "text/html")
    public String getMovies(Model model) {
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping(path = "/new", produces = "text/html")
    public String newMovie() {
        return "createMovie";
    }

    @PostMapping(path = "/new", produces = "text/html")
    public String createMovie(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return "success";
    }

    @GetMapping(path = "/search")
    public String getMoviesByGenre(@RequestParam(required = true) String genre, Model model) {
        List<Movie> movies = movieService.findAllByGenre(genre);
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping(path = "/mostReviewed", produces = "text/html")
    public String getMostReviewed(Model model) {
        List<Movie> movies = movieService.findMostReviewed();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping(path = "/longest", produces = "text/html")
    public String getLongest(Model model) {
        List<Movie> movies = movieService.findLongest();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping(path = "/highestRated", produces = "text/html")
    public String getHighestRated(Model model) {
        List<Movie> movies = movieService.findHighestRated();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping(path = "/oldest", produces = "text/html")
    public String getOldest(Model model) {
        List<Movie> movies = movieService.findOldestMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping(path = "/inAnyWatchlist", produces = "text/html")
    public String getInAnyWatchlist(Model model) {
        List<Movie> movies = movieService.findInAnyWatchlist();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping(path = "/withoutReviews", produces = "text/html")
    public String getWithoutReviews(Model model) {
        List<Movie> movies = movieService.findWithoutReviews();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @PostMapping(path = "/newReview", produces = "text/html")
    public String insertReview(@RequestParam(value="id") Integer id, @RequestParam(value="rating") Integer rating, @RequestParam(value="text") String text, Principal principal) {
        User user = userService.findUserByUsername(principal.getName());
        movieService.addReview(user.getId(), id, rating, text);
        return "success";
    }
}
