package com.amsysytem.service;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.entity.Employee;
import com.amsysytem.mappers.EmployeeMapper;
import com.amsysytem.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

        return employeeDtos;
        // todo sorting asc/desc
    }

    @Override
    public void save(EmployeeDto employeeDto) {
        employeeRepository.save(EmployeeMapper.mapToEmployee(employeeDto));
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
