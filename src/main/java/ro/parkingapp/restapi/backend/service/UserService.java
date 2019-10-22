package ro.parkingapp.restapi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.parkingapp.restapi.backend.dto.UserCreateDto;
import ro.parkingapp.restapi.backend.dto.UserDetailsDto;
import ro.parkingapp.restapi.backend.entity.User;
import ro.parkingapp.restapi.backend.mapper.UserMapper;
import ro.parkingapp.restapi.backend.repository.UserRatingAndCommentRepository;
import ro.parkingapp.restapi.backend.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;

@Configurable
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRatingAndCommentService userRatingAndCommentService;

    @Autowired
    private UserRatingAndCommentRepository userRatingAndCommentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(UserCreateDto userCreateDto) {
        User user = userMapper.convertToUser(userCreateDto);
        user.setCredits(BigDecimal.valueOf(100));
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        return userRepository.save(user);
    }

    public UserCreateDto getUser(User user) {
        UserCreateDto userCreateDto = userMapper.convertToDto(user);
        return userCreateDto;
    }

    public User findUserById(Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public void deleteUserByObject(User user) {
        userRatingAndCommentService.deleteAllByUserId(user.getId());
        userRepository.delete(user);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        userRatingAndCommentService.deleteAllByUserId(id);
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public int checkUser(String email, String password) {
        if (userRepository.checkEmail(email) != null) {
            if (passwordEncoder.matches(password, userRepository.checkPasswordByEmail(email)))
                return userRepository.getIdByEmail(email);
        }
        return -1;
    }

    public UserDetailsDto getUserDetails(User user) {
        UserDetailsDto userDetailsDto = userMapper.getUserDetails(user);
        List<Double> ratings = userRatingAndCommentRepository.getUserRatingById(user.getId());
        Double rating = Double.valueOf(0);
        for (Double i : ratings)
            rating += i;
        if (ratings.size() > 0)
            rating = rating / ratings.size();
        else
            rating = (double) 0;
        userDetailsDto.setRating(rating);
        return userDetailsDto;
    }
}
