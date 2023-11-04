package com.amsysytem.repositories;

import com.amsysytem.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {

    Optional<Request> findAllById(Long id);

}
