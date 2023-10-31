package com.amsysytem.dto;

import com.amsysytem.entity.Authority;

import com.amsysytem.entity.Employee;
import com.amsysytem.entity.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
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

    private Employee employee;

    private List<Request> requests = new ArrayList<>();
}
