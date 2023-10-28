package com.amsysytem.repositories;

import com.amsysytem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findByUsername(String name);
}
