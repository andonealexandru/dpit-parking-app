package ro.parkingapp.restapi.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ShareParkController {
    @RequestMapping(value = "/api/share_parking_lot?parkId={id}", method = RequestMethod.GET)
    public List<Map<String, String>> park_information_query() {
        //TODO:Create method fo this endpoint
        return null;
    }
}
