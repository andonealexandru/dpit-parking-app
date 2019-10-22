package ro.parkingapp.restapi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import ro.parkingapp.restapi.backend.dto.RateParkingDto;
import ro.parkingapp.restapi.backend.entity.ParkingRatingsAndComments;
import ro.parkingapp.restapi.backend.mapper.ParkingRatingAndCommentMapper;
import ro.parkingapp.restapi.backend.repository.ParkingRatingAndCommentRepository;

import java.util.List;

@Configurable
@Service
public class ParkingRatingAndCommentService {
    @Autowired
    ParkingRatingAndCommentRepository parkingRatingAndCommentRepository;
    @Autowired
    ParkingRatingAndCommentMapper parkingRatingAndCommentMapper;

    public void add(Integer id, RateParkingDto rateParkingDto) {
        ParkingRatingsAndComments parkingRatingsAndComments = parkingRatingAndCommentMapper.convertToParkingRatingAndComments(rateParkingDto);
        parkingRatingsAndComments.setParkingId(id);
        parkingRatingAndCommentRepository.save(parkingRatingsAndComments);
    }

    public void deleteAllByParkingId(Integer parkingId) {
        List<ParkingRatingsAndComments> parkingRatingsAndComments = parkingRatingAndCommentRepository.findAllByParkingId(parkingId);
        parkingRatingAndCommentRepository.deleteAll(parkingRatingsAndComments);
    }
}
