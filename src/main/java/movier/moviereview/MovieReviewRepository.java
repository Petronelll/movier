package movier.moviereview;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieReviewRepository extends CrudRepository<MovieReview, MovieReviewKey> {
}
