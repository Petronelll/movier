package movier.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("actor")
public class ActorController {

    ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping(path = "/{name}", produces = "application/json")
    public Actor getActor(@PathVariable String name) {
        return actorService.findActorByName(name);
    }

    @GetMapping(path = "/new", produces = "text/html")
    public String createActor() {
        return "createActor";
    }
}
