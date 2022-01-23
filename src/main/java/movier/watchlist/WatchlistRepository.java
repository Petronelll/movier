package movier.watchlist;

import movier.movie.Movie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WatchlistRepository extends CrudRepository<Watchlist, WatchlistKey> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO watchlist (user_id, movie_id) values (?1, ?2)", nativeQuery = true)
    void save(Integer user_id, Integer movie_id);
}
