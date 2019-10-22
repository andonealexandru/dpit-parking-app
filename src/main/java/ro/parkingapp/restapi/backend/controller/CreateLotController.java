package ro.parkingapp.restapi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.parkingapp.restapi.backend.dto.MyLotsDto;
import ro.parkingapp.restapi.backend.dto.ParkCoordinatesDto;
import ro.parkingapp.restapi.backend.dto.ParkingCreateDto;
import ro.parkingapp.restapi.backend.dto.ParkingGetDto;
import ro.parkingapp.restapi.backend.entity.ParkingLot;
import ro.parkingapp.restapi.backend.repository.ParkingRepository;
import ro.parkingapp.restapi.backend.service.MyLotsService;
import ro.parkingapp.restapi.backend.service.ParkingService;


import java.util.List;

@RestController
public class CreateLotController {

    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private MyLotsService myLotsService;

    @RequestMapping(value = "/api/add_lot/ownerId={ownerId}", method = RequestMethod.POST)
    public ParkingLot AddParkingLot(@RequestBody ParkingCreateDto parkingCreateDto, @PathVariable Integer ownerId) {
        return parkingService.postParking(parkingCreateDto, ownerId);
    }

    @RequestMapping(value = "/api/parking_lot/parkingId={id}/userId={userId}", method = RequestMethod.GET)
    public ParkingGetDto get_parking_data_with_user(@PathVariable Integer id, @PathVariable Integer userId) {
        ParkingLot parkingLot = parkingService.findParkingById(id);
        return parkingService.getParkingWithUser(parkingLot, id, userId);
    }

    @RequestMapping(value = "/api/parking_lot/parkingId={id}", method = RequestMethod.GET)
    public ParkingGetDto get_parking_data(@PathVariable Integer id) {
        ParkingLot parkingLot = parkingService.findParkingById(id);
        return parkingService.getParking(parkingLot, id);
    }

    @RequestMapping(value = "/api/parking_lot/parkingLatitude={lat}&parkingLongitude={lng}", method = RequestMethod.GET)
    public List<ParkCoordinatesDto> getParkCoordinates(@PathVariable Double lat, @PathVariable Double lng) {
        return parkingService.getParkingByCoordinates(parkingService.findParkingByCoordinates(lat, lng));
    }

    @RequestMapping(value = "/api/my_lots/ownerId={ownerId}", method = RequestMethod.GET)
    public List<MyLotsDto> getMyLots(@PathVariable Integer ownerId) {
        return myLotsService.getParkingLots(myLotsService.findParkingLots(ownerId));
    }


}
