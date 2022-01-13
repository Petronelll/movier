package movier.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor findActorByName(String name) {
        return actorRepository.findActorByName(name);
    }

    public String addActor(Actor actor) {
        String message;
        if (actorRepository.findActorByName(actor.getName()) != null)
            message = "Invalid actor name";
        else {
            actorRepository.insertActor(actor.getName(), actor.getImageUrl(), actor.getBiography());
            message = "ok";
        }
        return message;
    }
}
