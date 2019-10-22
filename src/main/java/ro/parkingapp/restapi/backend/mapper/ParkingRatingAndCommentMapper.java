package ro.parkingapp.restapi.backend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.parkingapp.restapi.backend.dto.RateParkingDto;
import ro.parkingapp.restapi.backend.entity.ParkingRatingsAndComments;

@Component
public class ParkingRatingAndCommentMapper {
    @Autowired
    private ModelMapper modelMapper;

    public RateParkingDto convertToDto(ParkingRatingsAndComments parkingRatingsAndComments) {
        RateParkingDto rateParkingDto = modelMapper.map(parkingRatingsAndComments, RateParkingDto.class);
        return rateParkingDto;
    }

    public ParkingRatingsAndComments convertToParkingRatingAndComments(RateParkingDto rateParkingDto) {
        ParkingRatingsAndComments parkingRatingsAndComments = modelMapper.map(rateParkingDto, ParkingRatingsAndComments.class);
        return parkingRatingsAndComments;
    }
}
