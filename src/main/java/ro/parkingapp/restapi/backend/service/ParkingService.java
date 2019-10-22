package ro.parkingapp.restapi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import ro.parkingapp.restapi.backend.dto.ParkCoordinatesDto;
import ro.parkingapp.restapi.backend.dto.ParkingCreateDto;
import ro.parkingapp.restapi.backend.dto.ParkingGetDto;
import ro.parkingapp.restapi.backend.entity.ParkingLot;
import ro.parkingapp.restapi.backend.mapper.ParkingMapper;
import ro.parkingapp.restapi.backend.repository.ParkingRatingAndCommentRepository;
import ro.parkingapp.restapi.backend.repository.ParkingRepository;
import ro.parkingapp.restapi.backend.repository.UserRepository;

import java.util.List;

@Configurable
@Service
public class ParkingService {
    @Autowired
    private ParkingMapper parkingMapper;
    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ParkingRatingAndCommentService parkingRatingAndCommentService;
    @Autowired
    private ParkingRatingAndCommentRepository parkingRatingAndCommentRepository;

    public ParkingLot findParkingById(Integer id) {
        ParkingLot parkingLot = parkingRepository.findById(id).get();
        return parkingLot;
    }

    public List<ParkingLot> findParkingByCoordinates(Double latitude, Double longitude) {
        return parkingRepository.getParkingLotByCoordinates(latitude - 0.5, latitude + 0.5, longitude - 0.5, longitude + 0.5);
    }

    public List<ParkCoordinatesDto> getParkingByCoordinates(List<ParkingLot> parkingLots) {
        List<ParkCoordinatesDto> parkingCreateDtos = parkingMapper.convertToParkingListDto(parkingLots);
        return parkingCreateDtos;
    }

    public ParkingGetDto getParkingWithUser(ParkingLot parkingLot, Integer id, Integer userId) {
        ParkingGetDto parkingLotDto = parkingMapper.convertToParkingGetDto(parkingLot);
        Integer ownerID = parkingLotDto.getOwnerId();
        parkingLotDto.setFirstName(userRepository.getFirstNameById(ownerID));
        parkingLotDto.setLastName(userRepository.getLastNameById(ownerID));
        parkingLotDto.setPhoneNumber(userRepository.getPhoneNumberById(ownerID));
        parkingLotDto.setCredits(userRepository.getCreditsByUserId(userId));
        List<Double> ratings = parkingRatingAndCommentRepository.getRating(parkingLot.getId());
        Double rating = Double.valueOf(0);
        for (Double i : ratings)
            rating += i;

        if (ratings.size() > 0)
            rating = rating / ratings.size();
        parkingLotDto.setRating(rating);
        return parkingLotDto;
    }

    public ParkingGetDto getParking(ParkingLot parkingLot, Integer id) {
        ParkingGetDto parkingLotDto = parkingMapper.convertToParkingGetDto(parkingLot);
        Integer ownerID = parkingLotDto.getOwnerId();
        parkingLotDto.setFirstName(userRepository.getFirstNameById(ownerID));
        parkingLotDto.setLastName(userRepository.getLastNameById(ownerID));
        parkingLotDto.setPhoneNumber(userRepository.getPhoneNumberById(ownerID));
        parkingLotDto.setCredits(userRepository.getCreditsByUserId(ownerID));
        List<Double> ratings = parkingRatingAndCommentRepository.getRating(parkingLot.getId());
        Double rating = Double.valueOf(0);
        for (Double i : ratings)
            rating += i;

        if (ratings.size() > 0)
            rating = rating / ratings.size();
        parkingLotDto.setRating(rating);
        return parkingLotDto;
    }

    public void saveParking(ParkingLot parkingLot) {
        parkingRepository.save(parkingLot);
    }

    public void deleteParking(ParkingLot parkingLot) {
        parkingRatingAndCommentService.deleteAllByParkingId(parkingLot.getId());
        parkingRepository.delete(parkingLot);
    }

    public ParkingLot postParking(ParkingCreateDto parkingCreateDto, int ownerId) {
        ParkingLot parkingLot = parkingMapper.convertToParkingLot(parkingCreateDto);
        parkingLot.setOwnerId(ownerId);
        parkingLot.setAvailable("Free");
        return parkingRepository.save(parkingLot);
    }
}
