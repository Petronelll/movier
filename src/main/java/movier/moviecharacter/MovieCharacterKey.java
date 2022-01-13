package movier.moviecharacter;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class MovieCharacterKey implements Serializable {

    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "actor_id")
    private Integer actorId;
}
