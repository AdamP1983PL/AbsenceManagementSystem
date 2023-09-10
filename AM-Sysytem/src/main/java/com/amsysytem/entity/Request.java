package com.amsysytem.entity;

import jakarta.persistence.*;
import com.amsysytem.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime dateTimeCreated;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "Ending_date")
    private LocalDate endingDate;

    @Column(name = "days_count")
    private int daysCount;

    @Column(name = "due_days")
    private int dueDays;

    @Column(columnDefinition = "ENUM('ACCEPTED', 'REJECTED', 'PENDING')", name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH}
    )
    @JoinColumn(name = "employee_id")
    private Employee employee;
}