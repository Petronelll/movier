package movier.moviecharacter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, MovieCharacterKey> {
}