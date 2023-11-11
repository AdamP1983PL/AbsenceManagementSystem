package com.amsysytem.mappers;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPassword(),
                employee.getPhoneNumber(),
                employee.getEmployeeRole(),
                employee.getRemainingDays(),
                employee.getRequest()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getPassword(),
                employeeDto.getPhoneNumber(),
                employeeDto.getEmployeeRole(),
                employeeDto.getRemainingDays(),
                employeeDto.getRequest()
        );
    }
}
