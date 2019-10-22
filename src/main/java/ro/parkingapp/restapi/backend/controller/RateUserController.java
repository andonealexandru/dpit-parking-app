package ro.parkingapp.restapi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.parkingapp.restapi.backend.dto.RateOwnerDto;
import ro.parkingapp.restapi.backend.service.UserRatingAndCommentService;

@RestController
public class RateUserController {
    @Autowired
    private UserRatingAndCommentService userRatingAndCommentService;

    @RequestMapping(value = "/api/rate/userId={id}", method = RequestMethod.POST)
    public void rate_user(@RequestBody RateOwnerDto rateOwnerDto, @PathVariable Integer id) {
        userRatingAndCommentService.add(id, rateOwnerDto);
    }
}
