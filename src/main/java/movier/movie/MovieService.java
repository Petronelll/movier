package movier.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public List<Movie> findAllByUserId(Integer id) {
        return movieRepository.findAllByUserId(id);
    }

    public List<Movie> findAllByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
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

    public String addReview(Integer user_id, Integer movie_id, Integer rating, String text) {
        movieRepository.insertReview(user_id, movie_id, rating, text);
        return "ok";
    }

    public void deleteMovieById(Integer id) {
        movieRepository.deleteMovieById(id);
    }

    public void updateMovieTitle(Integer id, String title) {
        movieRepository.updateMovieTitle(id, title);
    }

    public List<Movie> findMostReviewed() {
        return movieRepository.findMostReviewed();
    }

    public List<Movie> findLongest() {
        return movieRepository.findByMaxDuration();
    }

    public List<Movie> findHighestRated() {
        return movieRepository.findByMaxRating();
    }

    public List<Movie> findOldestMovies() {
        return movieRepository.findByMinReleaseYear();
    }

    public List<Movie> findInAnyWatchlist() {
        return movieRepository.FindInAnyWatchlist();
    }

    public List<Movie> findWithoutReviews() {
        return movieRepository.findWithoutReviews();
    }
}
