package com.amsysytem.dto;

import com.amsysytem.entity.Authority;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty(message = "User Name should not be empty")
    private String username;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    private Set<Authority> authorities;
}
