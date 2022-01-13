package movier.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("actor")
public class ActorController {

    ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping(path = "/{name}", produces = "text/html")
    public String getActor(@PathVariable String name, Model model) {
        Actor actor = actorService.findActorByName(name);
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
}
