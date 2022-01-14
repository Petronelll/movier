package movier.actor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {

    @Query(value = "SELECT * FROM actor WHERE name =  ?1", nativeQuery = true)
    Actor findActorByName(String name);

    //TODO
    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO actor (name, image_url, biography) values (:name, :imageUrl, :biography)",
            nativeQuery = true)
    void insertActor(@Param("name") String name,
                     @Param("imageUrl") String imageUrl,
                     @Param("biography") String biography);
}
