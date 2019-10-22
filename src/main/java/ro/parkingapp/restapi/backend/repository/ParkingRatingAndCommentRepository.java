package ro.parkingapp.restapi.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.parkingapp.restapi.backend.entity.ParkingRatingsAndComments;

import java.util.List;

public interface ParkingRatingAndCommentRepository extends CrudRepository<ParkingRatingsAndComments, Integer> {
    List<ParkingRatingsAndComments> findAllByParkingId(Integer userId);

    @Query("SELECT parkingRatingsAndComments.rating FROM ParkingRatingsAndComments parkingRatingsAndComments WHERE parkingId=?1")
    List<Double> getRating(Integer parkingId);
}
