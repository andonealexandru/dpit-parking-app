package ro.parkingapp.restapi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.parkingapp.restapi.backend.entity.ParkingLot;
import ro.parkingapp.restapi.backend.service.ParkingService;

@RestController
public class RentParkController {
    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value = "/api/parking_lot/rent/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String rentPark(@PathVariable Integer id) {
        ParkingLot parkingLot = parkingService.findParkingById(id);
        parkingLot.setAvailable("Closed");
        parkingService.saveParking(parkingLot);
        return "worked";
    }
}