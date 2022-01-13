package movier.actor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {

    @Query(value = "SELECT * FROM actor WHERE name =  ?1", nativeQuery = true)
    Actor findActorByName(String name);
}
