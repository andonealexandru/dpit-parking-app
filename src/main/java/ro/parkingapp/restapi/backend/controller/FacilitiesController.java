package ro.parkingapp.restapi.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.parkingapp.restapi.backend.dto.FacilitiesDto;
import ro.parkingapp.restapi.backend.mapper.FacilitiesMapper;
import ro.parkingapp.restapi.backend.repository.FacilitiesRepository;
import ro.parkingapp.restapi.backend.service.FacilitiesService;

import java.util.List;

@RestController
public class FacilitiesController {

    @Autowired
    private FacilitiesMapper facilitiesMapper;

    @Autowired
    private FacilitiesService facilitiesService;

    @Autowired
    private FacilitiesRepository facilitiesRepository;

    @RequestMapping(value = "/api/facilities", method = RequestMethod.GET)
    public List<FacilitiesDto> get_facilities() {
        return facilitiesService.getFacilities(facilitiesService.findFacilities());
    }


}
