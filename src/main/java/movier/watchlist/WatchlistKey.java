package movier.watchlist;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class WatchlistKey implements Serializable {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "movie_id")
    private int movieId;
}
