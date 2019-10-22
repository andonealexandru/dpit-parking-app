package ro.parkingapp.restapi.backend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.parkingapp.restapi.backend.dto.RateOwnerDto;
import ro.parkingapp.restapi.backend.entity.UserRatingsAndComments;

@Component
public class UserRatingAndCommentMapper {
    @Autowired
    private ModelMapper modelMapper;

    public RateOwnerDto convertToDto(UserRatingsAndComments userRatingsAndComments) {
        RateOwnerDto rateUserDto = modelMapper.map(userRatingsAndComments, RateOwnerDto.class);
        return rateUserDto;
    }

    public UserRatingsAndComments convertToParkingRatingAndComments(RateOwnerDto rateOwnerDto) {
        UserRatingsAndComments userRatingsAndComments = modelMapper.map(rateOwnerDto, UserRatingsAndComments.class);
        return userRatingsAndComments;
    }
}
