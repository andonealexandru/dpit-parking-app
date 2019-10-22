package ro.parkingapp.restapi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.parkingapp.restapi.backend.dto.*;
import ro.parkingapp.restapi.backend.entity.User;
import ro.parkingapp.restapi.backend.mapper.UserMapper;
import ro.parkingapp.restapi.backend.repository.UserRepository;
import ro.parkingapp.restapi.backend.service.UserRatingAndCommentService;
import ro.parkingapp.restapi.backend.service.UserService;

import java.math.BigDecimal;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserRatingAndCommentService userRatingAndCommentService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public User postUser(@RequestBody UserCreateDto userDto) {
        return userService.createUser(userDto);
    }

    @RequestMapping(value = "/api/users/id={id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        userRatingAndCommentService.deleteAllByUserId(id);
        userService.deleteUserByObject(user);
    }

    @RequestMapping(value = "/api/profile/userId={id}", method = RequestMethod.GET)
    public UserCreateDto get_user_data(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return userService.getUser(user);
    }

    @RequestMapping(value = "/api/profile/userId={id}", method = RequestMethod.PUT)
    public void update_user_data(@PathVariable Integer id, @RequestBody UserEditDto userEditDto) {

        User user = userService.findUserById(id);
        user.setPhoneNumber(userEditDto.getPhone_number());
        user.setLastName(userEditDto.getLast_name());
        user.setFirstName(userEditDto.getFirst_name());
        user.setEmail(userEditDto.getEmail());
        user.setPhoto(userEditDto.getPhoto());
        userService.saveUser(user);
    }

    @RequestMapping(value = "/api/users/contact_details/userId={id}", method = RequestMethod.GET)
    public UserContactDto get_contact_details(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        UserContactDto userContactDto;
        UserMapper userMapper = new UserMapper();
        userContactDto = userMapper.UserToContactDto(user);
        return userContactDto;
    }

    @RequestMapping(value = "/api/users/userMail={userMail}&userPass={userPass}", method = RequestMethod.GET)
    public int checkUser(@PathVariable String userMail, @PathVariable String userPass) {
        return userService.checkUser(userMail, userPass);
    }

    @RequestMapping(value = "/api/rate/id={id}", method = RequestMethod.PUT)
    public void rate_user(@RequestBody RateOwnerDto rateOwnerDto, @PathVariable Integer id) {
        userRatingAndCommentService.add(id, rateOwnerDto);
    }

    @RequestMapping(value = "/api/userDetails/userId={id}", method = RequestMethod.GET)
    public UserDetailsDto getUserDetails(@PathVariable Integer id) {
        return userService.getUserDetails(userService.findUserById(id));
    }

    @RequestMapping(value = "/api/updateUserDetails", method = RequestMethod.PUT)
    public @ResponseBody
    User updateUserDetails(@RequestBody UserDetailsDto userDetailsDto) {
        User user = userService.findUserById(userDetailsDto.getId());
        user.setEmail(userDetailsDto.getEmail());
        user.setPassword(userDetailsDto.getPassword());
        user.setPhoneNumber(userDetailsDto.getPhoneNumber());
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/api/parking_lot/user/{userBuyId}/{userGetId}/{credits}", method = RequestMethod.PUT)
    public @ResponseBody
    String changeCredits(@PathVariable Integer userBuyId, @PathVariable Integer userGetId, @PathVariable BigDecimal credits) {
        User userBuy = userService.findUserById(userBuyId);
        User userGet = userService.findUserById(userGetId);
        userBuy.setCredits(userBuy.getCredits().subtract(credits));
        userGet.setCredits(userGet.getCredits().add(credits));
        userService.saveUser(userBuy);
        userService.saveUser(userGet);
        return "worked";
    }

    @RequestMapping(value = "/api/parking_lot/user={userId}/{credits}", method = RequestMethod.PUT)
    public @ResponseBody
    String buyCredits(@PathVariable Integer userId, @PathVariable BigDecimal credits) {
        User buyer = userService.findUserById(userId);
        buyer.setCredits(buyer.getCredits().add(credits));
        userService.saveUser(buyer);
        return "credits added";
    }
}
