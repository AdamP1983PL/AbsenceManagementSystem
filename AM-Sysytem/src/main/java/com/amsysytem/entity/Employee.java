package com.amsysytem.entity;

import com.amsysytem.enums.EmployeeRole;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    //    todo private Authority authority?????

    @Column(name = "employee_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;

    @Column(name = "due_days", nullable = false)
    private int dueDays;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "employee",
            cascade = CascadeType.ALL)
    private List<Request> request = new ArrayList<>();

    @OneToOne(mappedBy = "employee")
    private User user;
}
