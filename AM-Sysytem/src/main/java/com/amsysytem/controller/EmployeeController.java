package com.amsysytem.controller;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("")
    public String listEmployees(Model model) {
        List<EmployeeDto> employeeDtoList = employeeServiceImpl.getAllEmployees();
        model.addAttribute("employeeDtoList", employeeDtoList);
        return "employees";
    }
}
