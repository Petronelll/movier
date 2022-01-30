package movier;

import movier.actor.ActorService;
import movier.movie.MovieService;
import movier.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    public String getAdminPage(Principal principal) {
        if (!principal.getName().equals("admin")) return "error";
        return "admin";
    }

    @PostMapping(path="/deleteMovie", produces = "text/html")
    public String deleteMovie(Principal principal, @RequestParam(value="id") Integer id) {
        if (!principal.getName().equals("admin")) return "error";
        movieService.deleteMovieById(id);
        return "success";
    }

    @PostMapping(path="/deleteActor", produces = "text/html")
    public String deleteActor(Principal principal, @RequestParam(value="id") Integer id) {
        if (!principal.getName().equals("admin")) return "error";
        actorService.deleteActorById(id);
        return "success";
    }

    @PostMapping(path="/updateMovieTitle", produces = "text/html")
    public String updateMovieTitle(Principal principal, @RequestParam(value="id") Integer id, @RequestParam(value="title") String title) {
        if (!principal.getName().equals("admin")) return "error";
        movieService.updateMovieTitle(id, title);
        return "success";
    }

    @PostMapping(path="/updateActorName", produces = "text/html")
    public String updateActorName(Principal principal, @RequestParam(value="id") Integer id, @RequestParam(value="name") String name) {
        if (!principal.getName().equals("admin")) return "error";
        actorService.updateActorName(id, name);
        return "success";
    }
}