package com.amsysytem.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role", nullable = false)
    private String role;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;
}
