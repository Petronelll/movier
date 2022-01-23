package movier.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("actor")
public class ActorController {

    ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping(path = "/{id}", produces = "text/html")
    public String getActor(@PathVariable Integer id, Model model) {
        Actor actor = actorService.findActorById(id);
        if (actor == null) {
            model.addAttribute("reason", "Actor not found");
            return "error";
        }
        model.addAttribute(actor);
        return "actor";
    }

    @GetMapping(path = "/new", produces = "text/html")
    public String newActor() {
        return "createActor";
    }

    @PostMapping(path = "/new", produces = "text/html")
    public String createActor(@ModelAttribute Actor actor, Model model) {
        String message = actorService.addActor(actor);
        if (message == "ok") return "success";
        model.addAttribute("reason", message);
        return "error";
    }

    @GetMapping(path = "/all", produces = "text/html")
    public String getAllActors(Model model) {
        List<Actor> actors = actorService.findAll();
        model.addAttribute("actors", actors);
        return "actors";
    }
}
