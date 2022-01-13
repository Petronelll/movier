package movier.moviereview;

import lombok.*;
import movier.movie.Movie;
import movier.user.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieReview {

    @EmbeddedId
    private MovieReviewKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    private Integer rating;
    private String text;
}
