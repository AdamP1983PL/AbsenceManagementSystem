package com.amsysytem.service;

import com.amsysytem.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    void save(EmployeeDto employeeDto);

    void updateEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long employeeDtoId);

    EmployeeDto getEmployeeDtoById(Long employeeDtoId);

    EmployeeDto findByEmail(String email);

}
