package com.amsysytem.controller;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/newEmployee")
    public String addNewEmployee(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        return "addNewEmployee";
    }

    @PostMapping("/save")
    public String saveNewEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "addNewEmployee";
        }

        employeeServiceImpl.save(employeeDto);
        return "redirect:/employees";
    }
}
