package movier.movie;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query(value = "SELECT * FROM movie WHERE id = ?1", nativeQuery = true)
    Movie findMovieById(Integer id);

    @Query(value = "SELECT * FROM movie", nativeQuery = true)
    List<Movie> findAll();

    @Query(value = "SELECT m.* FROM movie m JOIN watchlist w on m.id = w.movie_id WHERE w.user_id = ?1", nativeQuery = true)
    List<Movie> findAllByUserId(Integer id);

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

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie WHERE id = ?1", nativeQuery = true)
    void deleteMovieById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE movie SET title = ?2 WHERE id = ?1", nativeQuery = true)
    void updateMovieTitle(Integer id, String title);

}
