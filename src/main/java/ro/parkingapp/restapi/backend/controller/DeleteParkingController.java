package ro.parkingapp.restapi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.parkingapp.restapi.backend.entity.ParkingLot;
import ro.parkingapp.restapi.backend.service.ParkingService;


@RestController
public class DeleteParkingController {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value = "/api/delete_lot/parkingId={parkingId}", method = RequestMethod.DELETE)
    public void DeleteParkingLot(@PathVariable Integer parkingId) {
        ParkingLot parkingLot = parkingService.findParkingById(parkingId);
        parkingService.deleteParking(parkingLot);
    }
}
