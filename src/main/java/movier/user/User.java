package movier.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import movier.moviereview.MovieReview;
import movier.watchlist.Watchlist;
import movier.watchlist.WatchlistKey;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    private String username;

    @Email
    @NotEmpty
    private String email;

    @NotBlank
    //@Size(min = 6)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<MovieReview> movieReviews;

    @OneToMany(mappedBy = "user")
    private List<Watchlist> watchlists;
}
