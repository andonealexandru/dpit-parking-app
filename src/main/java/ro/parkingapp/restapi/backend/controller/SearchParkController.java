package ro.parkingapp.restapi.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchParkController {
    @RequestMapping(value = "/api/search_for_parking?lat={lat}&long={long}", method = RequestMethod.GET)
    public List<Map<String, String>> search_for_parking() {
        //TODO:Create method fo this endpoint
        return null;
    }
}
