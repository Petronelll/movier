package movier.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import movier.genre.Genre;
import movier.moviecharacter.MovieCharacter;
import movier.moviereview.MovieReview;
import movier.watchlist.Watchlist;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private Short releaseYear;
    private Short duration; //minutes
    private String description;
    private String imageUrl;
    private String trailerUrl;

    @OneToMany(mappedBy = "movie")
    private List<Genre> genres;

    @OneToMany(mappedBy = "movie")
    private List<MovieReview> movieReviews;

    @OneToMany(mappedBy = "movie")
    private List<MovieCharacter> movieCharacters;

    @ManyToOne
    @JoinColumn(name = "watchlist_id", referencedColumnName = "id")
    private Watchlist watchlist;
}
