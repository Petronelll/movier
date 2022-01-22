package movier;

import movier.actor.ActorService;
import movier.movie.MovieService;
import movier.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminController {
    MovieService movieService;
    ActorService actorService;

    @Autowired
    public AdminController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }

    @GetMapping(path="", produces = "text/html")
    public String getAdminPage() {
        return "admin";
    }

    @PostMapping(path="/deleteMovie", produces = "text/html")
    public String deleteMovie(@RequestParam(value="id") Integer id) {
        movieService.deleteMovieById(id);
        return "success";
    }

    @PostMapping(path="/deleteActor", produces = "text/html")
    public String deleteActor(@RequestParam(value="id") Integer id) {
        actorService.deleteActorById(id);
        return "success";
    }

    @PostMapping(path="/updateMovieTitle", produces = "text/html")
    public String updateMovieTitle(@RequestParam(value="id") Integer id, @RequestParam(value="title") String title) {
        movieService.updateMovieTitle(id, title);
        return "success";
    }

    @PostMapping(path="/updateActorName", produces = "text/html")
    public String updateActorName(@RequestParam(value="id") Integer id, @RequestParam(value="name") String name) {
        actorService.updateActorName(id, name);
        return "success";
    }
}