package ro.parkingapp.restapi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.parkingapp.restapi.backend.dto.HistoryDto;
import ro.parkingapp.restapi.backend.entity.History;
import ro.parkingapp.restapi.backend.repository.ParkingRepository;
import ro.parkingapp.restapi.backend.service.HistoryService;

import java.util.List;

@RestController
public class HistoryController {
    @Autowired
    HistoryService historyService;
    @Autowired
    ParkingRepository parkingRepository;

    @RequestMapping(value = "/api/history/userId={id}", method = RequestMethod.GET)
    public List<HistoryDto> history_query(@PathVariable Integer id) {
        return historyService.getHistory(historyService.findHistory(id));
    }

    @RequestMapping(value = "/api/history/userId={userId}/parkingLot={parkingId}", method = RequestMethod.POST)
    public History post_history(@PathVariable Integer userId, @PathVariable Integer parkingId) {
        return historyService.postHistory(userId, parkingId);
    }
}
