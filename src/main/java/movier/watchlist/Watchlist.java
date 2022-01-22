package movier.watchlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import movier.movie.Movie;
import movier.user.User;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Watchlist {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy = "watchlist")
    private User user;

    @OneToMany(mappedBy = "watchlist")
    private List<Movie> movies;
}