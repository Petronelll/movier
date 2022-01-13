package movier.genre;

import lombok.*;
import movier.movie.Movie;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @GeneratedValue
    private Integer id;

    //@Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="movie_id", referencedColumnName = "id")
    private Movie movie;
}
