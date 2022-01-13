package movier.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import movier.moviereview.MovieReview;
import movier.watchlist.Watchlist;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "watchlist_id", referencedColumnName = "id")
    private Watchlist watchlist;

    @OneToMany(mappedBy = "user")
    private List<MovieReview> movieReviews;
}
