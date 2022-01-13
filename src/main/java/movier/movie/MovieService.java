package movier.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findMovieById(Integer id) {
        return movieRepository.findMovieById(id);
    }

    public String addMovie(Movie movie) {
        movieRepository.insertMovie(
                movie.getTitle(),
                movie.getReleaseYear(),
                movie.getDuration(),
                movie.getDescription(),
                movie.getImageUrl()
        );
        return "ok";
    }
}
