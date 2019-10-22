package ro.parkingapp.restapi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.parkingapp.restapi.backend.entity.ParkingLot;
import ro.parkingapp.restapi.backend.service.ParkingService;

@RestController
public class FreeParkController {

    @Autowired
    ParkingService parkingService;

    @RequestMapping(value = "/api/free_parking_lot/parkId={id}", method = RequestMethod.PUT)
    public String free_parking(@PathVariable Integer id) {
        ParkingLot parkingLot = parkingService.findParkingById(id);
        parkingLot.setAvailable("Free");
        parkingService.saveParking(parkingLot);
        return "worked";
    }
}