package com.amsysytem.service;

import com.amsysytem.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return null;
    }

    @Override
    public void save(EmployeeDto employeeDto) {

    }

    @Override
    public EmployeeDto getEmployeeDtoById(Long employeeDtoId) {
        return null;
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {

    }

    @Override
    public void deleteEmployee(Long employeeDtoId) {

    }
}
