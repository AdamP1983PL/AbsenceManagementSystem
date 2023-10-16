package com.amsysytem.mappers;

import com.amsysytem.dto.UserDto;
import com.amsysytem.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getPassword()
        );
    }
}

// todo password field in UserDto?????
