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

    @Query(value = "SELECT * FROM movie m JOIN genre g on m.genre_id = g.id JOIN movie_character mc on m.id = mc.movie_id JOIN movie_review mr on m.id = mr.movie_id JOIN user u on mr.user_id = u.id WHERE m.id = ?1", nativeQuery = true)
    Movie findAllById(Integer id);

    @Query(value = "SELECT * FROM movie", nativeQuery = true)
    List<Movie> findAll();

    @Query(value = "SELECT m.* FROM movie m JOIN watchlist w on m.id = w.movie_id WHERE w.user_id = ?1", nativeQuery = true)
    List<Movie> findAllByUserId(Integer id);

    @Query(value = "SELECT m.* FROM movie m JOIN genre g on m.genre_id = g.id WHERE g.name = ?1", nativeQuery = true)
    List<Movie> findAllByGenre(String genre);

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
    @Query(value = "INSERT INTO movie_review (movie_id, user_id, rating, text) values (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertReview(Integer user_id, Integer movie_id, Integer rating, String text);

    @Transactional
    @Modifying
    @Query(value = "UPDATE movie SET title = ?2 WHERE id = ?1", nativeQuery = true)
    void updateMovieTitle(Integer id, String title);

    @Query(value = "SELECT m.* FROM movie m JOIN movie_review mr on m.id = mr.movie_id GROUP BY m.id HAVING COUNT(m.id) = (SELECT COUNT(MR.movie_id) FROM movie_review MR GROUP BY MR.movie_id ORDER BY COUNT(mr.movie_id) DESC LIMIT 1)", nativeQuery = true)
    public List<Movie> findMostReviewed();

    @Query(value = "SELECT m.* FROM movie m WHERE m.duration = (SELECT MAX(duration) FROM movie)", nativeQuery = true)
    public List<Movie> findByMaxDuration();

    @Query(value = "SELECT m.* FROM movie m JOIN movie_review mr on m.id = mr.movie_id GROUP BY m.id HAVING AVG(mr.rating) = (SELECT AVG(MR.rating) FROM movie_review MR GROUP BY MR.movie_id ORDER BY AVG(MR.rating) DESC LIMIT 1)", nativeQuery = true)
    public List<Movie> findByMaxRating();

    @Query(value = "SELECT m.* FROM movie m WHERE m.release_year = (SELECT MIN(release_year) FROM movie)", nativeQuery = true)
    public List<Movie> findByMinReleaseYear();

    @Query(value = "SELECT m.* FROM movie m WHERE m.id IN (SELECT movie_id FROM watchlist)", nativeQuery = true)
    public List<Movie> FindInAnyWatchlist();

    @Query(value = "SELECT m.* FROM movie m WHERE m.id NOT IN (SELECT movie_id FROM movie_review)", nativeQuery = true)
    public List<Movie> findWithoutReviews();

    Movie findMovieById(Integer id);
}
