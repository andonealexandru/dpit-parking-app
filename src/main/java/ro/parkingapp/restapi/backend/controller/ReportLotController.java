package ro.parkingapp.restapi.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportLotController {
    @RequestMapping(value = "api/report", method = RequestMethod.POST)
    public void postReport() {
        //TODO:Create method fo this endpoint
    }
}
