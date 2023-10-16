package com.amsysytem.service;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.mappers.EmployeeMapper;
import com.amsysytem.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

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
