package com.amsysytem.controller;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/managersList")
    public String listEmployeesManagersSpace(Model model) {
        List<EmployeeDto> employeeDtoList = employeeServiceImpl.getAllEmployees();
        model.addAttribute("employeeDtoList", employeeDtoList);
        return "employeesManagersSpace";
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

    @GetMapping("/{employeeDtoId}/edit")
    public String editEmployee(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        EmployeeDto employeeDto = employeeServiceImpl.getEmployeeDtoById(employeeDtoId);
        model.addAttribute("employeeDto", employeeDto);
        return "editEmployee";
    }

    @PostMapping("/{employeeDtoId}")
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
        return "redirect:/employees";
    }

    @GetMapping("/{employeeDtoId}/delete")
    public String deleteEmployee(@PathVariable("employeeDtoId") Long employeeDtoId) {
        employeeServiceImpl.deleteEmployee(employeeDtoId);
        return "redirect:/employees";
    }

    @GetMapping("/{employeeDtoId}/details")
    public String showEmployeeDetails(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        EmployeeDto employeeDetailsDto = employeeServiceImpl.getEmployeeDtoById(employeeDtoId);
        model.addAttribute("employeeDetailsDto", employeeDetailsDto);
        return "employeeDetails";
    }

    @GetMapping("/{employeeDtoId}/detailsManagersSpace")
    public String showEmployeeDetailsManagersSpace(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        EmployeeDto employeeDetailsDto = employeeServiceImpl.getEmployeeDtoById(employeeDtoId);
        model.addAttribute("employeeDetailsDto", employeeDetailsDto);
        return "employeeDetailsManagersSpace";
    }

}






























