package com.amsysytem.dto;

import com.amsysytem.entity.Employee;
import com.amsysytem.entity.User;
import com.amsysytem.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    private Long id;

    @NotEmpty(message = "Last Name should not be empty")
    private String lastName;

    @NotEmpty(message = "First Name should not be empty")
    private String firstName;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    private LocalDateTime dateTimeCreated;

//    @NotEmpty(message = "Starting date should not be empty")
    private LocalDate startingDate;

//    @NotEmpty(message = "Ending date should not be empty")
    private LocalDate endingDate;

    private int daysCount;

    private int dueDays;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Employee employee;

    private User user;
}
