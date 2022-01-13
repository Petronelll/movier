package movier.movie;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query(value = "SELECT * FROM movie WHERE id = ?1", nativeQuery = true)
    Movie findMovieById(Integer  id);

    //TODO
    @Transactional
    @Modifying
    @Query(
            value =
                    "INSERT INTO movie (title, release_year, duration, description, image_url) " +
                            "values (:title, :releaseYear, :duration, :description, :imageUrl)",
            nativeQuery = true)
    void insertMovie(@Param("title") String title,
                     @Param("releaseYear") Short releaseYear,
                     @Param("duration") Short duration,
                     @Param("description") String description,
                     @Param("imageUrl") String imageUrl);
}
