package com.amsysytem.controller;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("admin/employees")
    public String listEmployees(Model model) {
        List<EmployeeDto> employeeDtoList = employeeServiceImpl.getAllEmployees();
        model.addAttribute("employeeDtoList", employeeDtoList);
        return "employees";
    }

    @GetMapping("/admin/newEmployee")
    public String addNewEmployee(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        return "addNewEmployee";
    }

    @PostMapping("admin/saveNewEmployee")
    public String saveNewEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "addNewEmployee";
        }

        employeeServiceImpl.save(employeeDto);
        return "redirect:/admin/employees";
    }

    @GetMapping("admin/{employeeDtoId}/edit")
    public String editEmployee(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        EmployeeDto employeeDto = employeeServiceImpl.getEmployeeDtoById(employeeDtoId);
        model.addAttribute("employeeDto", employeeDto);
        return "editEmployee";
    }

    @PostMapping("/admin/{employeeDtoId}")
    public String updateEmployee(@PathVariable("employeeDtoId") Long employeeDtoId,
                                 @Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                 BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "editEmployee";
        }
        employeeDto.setId(employeeDtoId);
        employeeServiceImpl.updateEmployee(employeeDto);
        return "redirect:/admin/employees";
    }

    @GetMapping("admin/{employeeDtoId}/delete")
    public String deleteEmployee(@PathVariable("employeeDtoId") Long employeeDtoId) {
        employeeServiceImpl.deleteEmployee(employeeDtoId);
        return "redirect:/admin/employees";
    }

    @GetMapping("admin/{employeeDtoId}/details")
    public String showEmployeeDetails(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        EmployeeDto employeeDetailsDto = employeeServiceImpl.getEmployeeDtoById(employeeDtoId);
        model.addAttribute("employeeDetailsDto", employeeDetailsDto);
        return "employeeDetails";
    }
}
