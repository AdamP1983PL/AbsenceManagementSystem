package com.amsysytem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_authority",
            joinColumns = {@JoinColumn(name = "USER_Id", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private Set<Authority> authorities;

    @Column(name = "account_not_expired", nullable = false)
    private Boolean accountNotExpired = true;

    @Column(name = "account_not_locked", nullable = false)
    private Boolean accountNonLocked = true;

    @Column(name = "Credentials_not_expired", nullable = false)
    private Boolean credentialsNonExpired = true;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;
}
