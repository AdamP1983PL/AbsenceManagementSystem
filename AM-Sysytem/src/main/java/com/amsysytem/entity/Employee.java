package com.amsysytem.entity;

import com.amsysytem.enums.EmployeeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "employee_role")
    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;

    @Column(name = "due_days")
    private int dueDays;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "employee",
            cascade = CascadeType.ALL)
    private List<Request> request = new ArrayList<>();
}