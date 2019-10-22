package ro.parkingapp.restapi.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SharedLotsController {
    @RequestMapping(value = "api/shared/userId={id}", method = RequestMethod.GET)
    public List<Map<String, String>> normal_query_shared_lot() {
        //TODO:Create method fo this endpoint
        return null;
    }

    @RequestMapping(value = "api/shared/entryId={shared_entry_id}", method = RequestMethod.GET)
    public List<Map<String, String>> specific_query_shared_lot() {
        //TODO:Create method fo this endpoint
        return null;
    }
}
