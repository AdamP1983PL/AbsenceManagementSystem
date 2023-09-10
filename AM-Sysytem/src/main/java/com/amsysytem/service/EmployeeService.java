package com.amsysytem.service;

import com.amsysytem.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    void save(EmployeeDto employeeDto);

    EmployeeDto getEmployeeDtoById(Long employeeDtoId);

    void updateEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long employeeDtoId);
}
