package ro.parkingapp.restapi.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.parkingapp.restapi.backend.entity.UserRatingsAndComments;

import java.util.List;

public interface UserRatingAndCommentRepository extends CrudRepository<UserRatingsAndComments, Integer> {
    List<UserRatingsAndComments> findAllByUserId(Integer userId);

    @Query("SELECT userRatingAndComments.rating FROM UserRatingsAndComments userRatingAndComments WHERE userRatingAndComments.userId=?1")
    List<Double> getUserRatingById(Integer id);
}

