package ro.parkingapp.restapi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import ro.parkingapp.restapi.backend.dto.MyLotsDto;
import ro.parkingapp.restapi.backend.entity.ParkingLot;
import ro.parkingapp.restapi.backend.mapper.MyLotsMapper;
import ro.parkingapp.restapi.backend.repository.ParkingRatingAndCommentRepository;
import ro.parkingapp.restapi.backend.repository.ParkingRepository;
import ro.parkingapp.restapi.backend.repository.UserRepository;

import java.util.List;

@Service
@Configurable
public class MyLotsService {
    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private MyLotsMapper myLotsMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ParkingRatingAndCommentRepository parkingRatingAndCommentRepository;

    public List<ParkingLot> findParkingLots(Integer id) {
        return parkingRepository.getParkingLotByOwnerId(id);
    }

    public List<MyLotsDto> getParkingLots(List<ParkingLot> parkingLots) {
        List<MyLotsDto> myLotsDto = myLotsMapper.convertToDto(parkingLots);
        for (MyLotsDto i : myLotsDto) {
            List<Double> ratings = parkingRatingAndCommentRepository.getRating(i.getId());
            Double rating = Double.valueOf(0);
            for (Double j : ratings)
                rating += j;
            if (ratings.size() > 0)
                rating = rating / ratings.size();
            i.setRating(rating);

            //User
            System.out.println(i.getOwnerId());
            i.setFirstName(userRepository.getFirstNameById(i.getOwnerId()));
            i.setLastName(userRepository.getLastNameById(i.getOwnerId()));

            //ParkingLot
            i.setPhoto(parkingRepository.getParkingLotPhotoById(i.getId()));
            i.setLocation(parkingRepository.getParkingLotLocationById(i.getId()));
            i.setPrice(parkingRepository.getParkingLotPriceById(i.getId()));
            i.setStartHours(parkingRepository.getParkingLotStartHourById(i.getId()));
            i.setEndHours(parkingRepository.getParkingLotEndHourById(i.getId()));
        }
        return myLotsDto;
    }

}
