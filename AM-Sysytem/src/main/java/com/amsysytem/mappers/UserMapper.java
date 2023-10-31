package com.amsysytem.mappers;

import com.amsysytem.dto.UserDto;
import com.amsysytem.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities(),
                user.getEmployee(),
                user.getRequests()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getAuthorities(),
                userDto.getEmployee(),
                userDto.getRequests()
        );
    }
}

// todo password field in UserDto?????
