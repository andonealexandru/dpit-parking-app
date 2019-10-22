package ro.parkingapp.restapi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import ro.parkingapp.restapi.backend.dto.HistoryDto;
import ro.parkingapp.restapi.backend.dto.PostHistoryDto;
import ro.parkingapp.restapi.backend.entity.History;
import ro.parkingapp.restapi.backend.mapper.HistoryMapper;
import ro.parkingapp.restapi.backend.repository.HistoryRepository;
import ro.parkingapp.restapi.backend.repository.ParkingRatingAndCommentRepository;
import ro.parkingapp.restapi.backend.repository.ParkingRepository;
import ro.parkingapp.restapi.backend.repository.UserRepository;

import java.util.List;

@Service
@Configurable
public class HistoryService {
    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private ParkingRatingAndCommentRepository parkingRatingAndCommentRepository;

    public List<History> findHistory(Integer id) {
        return (List<History>) historyRepository.findAllByRenterUserId(id);
    }

    public List<HistoryDto> getHistory(List<History> history) {
        List<HistoryDto> historyDto = historyMapper.convertToDto(history);
        for (HistoryDto i : historyDto) {
            //ParkingRatingAndComments
            List<Double> ratings = parkingRatingAndCommentRepository.getRating(i.getParkingLotId());
            Double rating = Double.valueOf(0);
            for (Double j : ratings)
                rating += j;
            if (ratings.size() > 0)
                rating = rating / ratings.size();
            i.setRating(rating);

            //User
            i.setFirstName(userRepository.getFirstNameById(i.getRenterUserId()));
            i.setLastName(userRepository.getLastNameById(i.getRenterUserId()));

            //ParkingLot
            i.setPhoto(parkingRepository.getParkingLotPhotoById(i.getParkingLotId()));
            i.setLocation(parkingRepository.getParkingLotLocationById(i.getParkingLotId()));
            i.setPrice(parkingRepository.getParkingLotPriceById(i.getParkingLotId()));
            i.setStartHours(parkingRepository.getParkingLotStartHourById(i.getParkingLotId()));
            i.setEndHours(parkingRepository.getParkingLotEndHourById(i.getParkingLotId()));
        }
        return historyDto;
    }

    public History postHistory(Integer userId, Integer parkingId) {
        PostHistoryDto postHistoryDto = new PostHistoryDto();
        postHistoryDto.setParkingLotId(parkingId);
        postHistoryDto.setRenterUserId(userId);
        History history = historyMapper.convertToHistory(postHistoryDto);
        return historyRepository.save(history);
    }
}
