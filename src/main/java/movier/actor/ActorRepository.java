package movier.actor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {

    @Query(value = "SELECT * FROM actor WHERE id =  ?1", nativeQuery = true)
    Actor findActorById(Integer id);

    @Query(value = "SELECT * FROM actor", nativeQuery = true)
    List<Actor> findAll();

    //TODO
    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO actor (name, image_url, biography) values (:name, :imageUrl, :biography)",
            nativeQuery = true)
    void insertActor(@Param("name") String name,
                     @Param("imageUrl") String imageUrl,
                     @Param("biography") String biography);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM actor WHERE id = ?1", nativeQuery = true)
    void deleteActorById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE actor SET name = ?2 WHERE id = ?1", nativeQuery = true)
    void updateActorName(Integer id, String name);
}
