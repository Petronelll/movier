package movier.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("movie")
public class MovieController {

    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
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

    @GetMapping(path = "/new", produces = "text/html")
    public String newMovie() {
        return "createMovie";
    }

    @PostMapping(path = "/new", produces = "text/html")
    public String createMovie(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return "success";
    }
}
