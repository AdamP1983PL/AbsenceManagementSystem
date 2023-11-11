package com.amsysytem.repositories;

import com.amsysytem.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findAllByEmployeeId(Long id);

    List<Request> findAllByEmail(String name);
}
