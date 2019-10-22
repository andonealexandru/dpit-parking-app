package ro.parkingapp.restapi.backend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.parkingapp.restapi.backend.dto.UserContactDto;
import ro.parkingapp.restapi.backend.dto.UserCreateDto;
import ro.parkingapp.restapi.backend.dto.UserDetailsDto;
import ro.parkingapp.restapi.backend.dto.UserEditDto;
import ro.parkingapp.restapi.backend.entity.User;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertToUser(UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);
        return user;
    }

    public UserCreateDto convertToDto(User user) {
        UserCreateDto userCreateDto = modelMapper.map(user, UserCreateDto.class);
        return userCreateDto;
    }

    public User EditDtoToUser(UserEditDto userEditDto) {
        User user = modelMapper.map(userEditDto, User.class);
        return user;
    }

    public UserEditDto UserToEditDto(User user) {
        UserEditDto userEditDto = modelMapper.map(user, UserEditDto.class);
        return userEditDto;
    }

    public UserContactDto UserToContactDto(User user) {
        UserContactDto userContactDto = modelMapper.map(user, UserContactDto.class);
        return userContactDto;
    }

    public UserDetailsDto getUserDetails(User user) {
        UserDetailsDto userDetailsDto = modelMapper.map(user, UserDetailsDto.class);
        return userDetailsDto;
    }

}
