package movier.watchlist;

import movier.movie.Movie;
import movier.movie.MovieService;
import movier.user.User;
import movier.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("watchlist")
public class WatchlistController {

    WatchlistService watchlistService;
    MovieService movieService;
    UserService userService;

    public WatchlistController(WatchlistService watchlistService, MovieService movieService, UserService userService) {
        this.watchlistService = watchlistService;
        this.movieService = movieService;
        this.userService = userService;
    }

    @GetMapping(path = "", produces = "text/html")
    public String getWatchlist(Principal principal, Model model) {
        User user = userService.findUserByUsername(principal.getName());
        List<Movie> movies = movieService.findAllByUserId(user.getId());
        model.addAttribute("movies", movies);
        return "movies";
    }

    @PostMapping(path = "", produces = "text/html")
    public String insertEntryInWatchlist(@RequestParam(value="id") Integer id, Principal principal) {
        User user = userService.findUserByUsername(principal.getName());
        watchlistService.save(user.getId(), id);
        return "success";
    }
}
