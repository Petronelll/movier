package movier.moviecharacter;

import movier.actor.Actor;
import movier.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, MovieCharacterKey> {
}