package dev.vashist.movies.repository;

import dev.vashist.movies.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends MongoRepository<Review,Object> {


}
