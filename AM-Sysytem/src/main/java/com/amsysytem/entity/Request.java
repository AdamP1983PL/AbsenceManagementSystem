package com.amsysytem.entity;

import com.amsysytem.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "email", nullable = false)
    private String email;

    @CreationTimestamp
    @Column(name = "created", nullable = false)
    private LocalDateTime dateTimeCreated;

    @Column(name = "starting_date", nullable = false)
    private LocalDate startingDate;

    @Column(name = "Ending_date", nullable = false)
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
