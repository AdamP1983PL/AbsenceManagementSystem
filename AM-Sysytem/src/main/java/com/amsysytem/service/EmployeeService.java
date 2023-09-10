package com.amsysytem.service;

import com.amsysytem.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    void save(EmployeeDto employeeDto);

    EmployeeDto getEmployeeDtoById(Long employeeDtoId);

    void updateEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long employeeDtoId);
}
