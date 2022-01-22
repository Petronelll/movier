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

    public Actor findActorById(Integer id) {
        return actorRepository.findActorById(id);
    }

    public String addActor(Actor actor) {
        String message;
        if (actorRepository.findActorById(actor.getId()) != null)
            message = "Invalid actor name";
        else {
            actorRepository.insertActor(actor.getName(), actor.getImageUrl(), actor.getBiography());
            message = "ok";
        }
        return message;
    }

    public void deleteActorById(Integer id) {
        actorRepository.deleteActorById(id);
    }

    public void updateActorName(Integer id, String name) {
        actorRepository.updateActorName(id, name);
    }
}
