package movier.genre;

import lombok.*;
import movier.movie.Movie;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "genre")
    private List<Movie> genres;
}
