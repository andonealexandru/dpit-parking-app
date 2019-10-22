package ro.parkingapp.restapi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.parkingapp.restapi.backend.dto.RateParkingDto;
import ro.parkingapp.restapi.backend.service.ParkingRatingAndCommentService;

@RestController
public class RateParkController {
    @Autowired
    private ParkingRatingAndCommentService parkingRatingAndCommentService;

    @RequestMapping(value = "/api/rate/parking_lot/{parking_lot_id}", method = RequestMethod.POST)
    public void rate_parking(@RequestBody RateParkingDto rateParkingDto, @PathVariable Integer parking_lot_id) {
        parkingRatingAndCommentService.add(parking_lot_id, rateParkingDto);
    }
}
