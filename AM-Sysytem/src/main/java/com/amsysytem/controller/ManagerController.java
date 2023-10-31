package com.amsysytem.controller;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ManagerController {

    private final EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("manager/managersList")
    public String listEmployeesManagersSpace(Model model) {
        List<EmployeeDto> employeeDtoList = employeeServiceImpl.getAllEmployees();
        model.addAttribute("employeeDtoList", employeeDtoList);
        return "employeesManagersSpace";
    }

    @GetMapping("/manager/{employeeDtoId}/detailsManagersSpace")
    public String showEmployeeDetailsManagersSpace(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        EmployeeDto employeeDetailsDto = employeeServiceImpl.getEmployeeDtoById(employeeDtoId);
        model.addAttribute("employeeDetailsDto", employeeDetailsDto);
        return "employeeDetailsManagersSpace";
    }
}

//todo change camelCase in html names


//    @GetMapping("/employees-managers-list")
//    public String listEmployeesManagerMode(Model model){
//        List<EmployeeDto> employeeDtoList = employeeServiceImpl.getAllEmployees();
//        model.addAttribute("employeeDtoList", employeeDtoList);
//        return "employees-manager-mode";
//    }



























