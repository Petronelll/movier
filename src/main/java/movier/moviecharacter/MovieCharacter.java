package movier.moviecharacter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import movier.actor.Actor;
import movier.movie.Movie;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieCharacter {

    @EmbeddedId
    private MovieCharacterKey id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id", referencedColumnName = "id")
    private Actor actor;

    private String characterName;
}
