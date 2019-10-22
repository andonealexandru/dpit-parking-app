package ro.parkingapp.restapi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import ro.parkingapp.restapi.backend.dto.RateOwnerDto;
import ro.parkingapp.restapi.backend.entity.UserRatingsAndComments;
import ro.parkingapp.restapi.backend.mapper.UserRatingAndCommentMapper;
import ro.parkingapp.restapi.backend.repository.UserRatingAndCommentRepository;

import java.util.List;

@Configurable
@Service
public class UserRatingAndCommentService {
    @Autowired
    private UserRatingAndCommentMapper userRatingAndCommentMapper;
    @Autowired
    private UserRatingAndCommentRepository userRatingAndCommentRepository;

    public void add(Integer id, RateOwnerDto rateOwnerDto) {
        UserRatingsAndComments userRatingsAndComments = userRatingAndCommentMapper.convertToParkingRatingAndComments(rateOwnerDto);
        userRatingsAndComments.setUserId(id);
        userRatingAndCommentRepository.save(userRatingsAndComments);
    }

    public void deleteAllByUserId(Integer userId) {
        List<UserRatingsAndComments> userRatingsAndComments = userRatingAndCommentRepository.findAllByUserId(userId);
        userRatingAndCommentRepository.deleteAll(userRatingsAndComments);
    }

}
