package com.amsysytem.dto;

import com.amsysytem.entity.Employee;
import com.amsysytem.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.validation.constraints.Future;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    private Long id;

    private String lastName;

    private String firstName;

    private String email;

    @CreationTimestamp
    private LocalDateTime dateTimeCreated;

    @NotNull(message = "Starting date should not be empty")
    @Future (message = "Starting date should be in the future")
    private LocalDate startingDate;

    @NotNull(message = "Starting date should not be empty")
    @Future (message = "Starting date should be in the future")
    private LocalDate endingDate;

    @NotNull(message = "Count working days, Your Manager is going to check it.")
    private int daysCount;

    @Column(name = "remaining_days")
    private int remainingDays;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Employee employee;
}
