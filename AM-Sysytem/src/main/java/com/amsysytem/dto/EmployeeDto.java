package com.amsysytem.dto;

import com.amsysytem.entity.Request;
import com.amsysytem.enums.EmployeeRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;

    @NotEmpty(message = "Last Name should not be empty")
    private String lastName;

    @NotEmpty(message = "First Name should not be empty")
    private String firstName;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotEmpty(message = "Phone number should not be empty")
    private String phoneNumber;

    private EmployeeRole employeeRole;

    @Min(0)
    @Max(52)
    private int dueDays;

    private List<Request> request = new ArrayList<>();
}
