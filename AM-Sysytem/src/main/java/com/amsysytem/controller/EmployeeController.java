package com.amsysytem.controller;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
//@RequestMapping("")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

//  todo /admin
    @GetMapping("admin/employees")
    public String listEmployees(Model model) {
        List<EmployeeDto> employeeDtoList = employeeServiceImpl.getAllEmployees();
        model.addAttribute("employeeDtoList", employeeDtoList);
        return "employees";
    }

//    @GetMapping("/employees-managers-list")
//    public String listEmployeesManagerMode(Model model){
//        List<EmployeeDto> employeeDtoList = employeeServiceImpl.getAllEmployees();
//        model.addAttribute("employeeDtoList", employeeDtoList);
//        return "employees-manager-mode";
//    }

//    todo /manager
    @GetMapping("manager/managersList")
    public String listEmployeesManagersSpace(Model model) {
        List<EmployeeDto> employeeDtoList = employeeServiceImpl.getAllEmployees();
        model.addAttribute("employeeDtoList", employeeDtoList);
        return "employeesManagersSpace";
    }



    @GetMapping("/admin/newEmployee")
    public String addNewEmployee(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        return "addNewEmployee";
    }

//    todo /admin
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

//    todo /admin
    @GetMapping("admin/{employeeDtoId}/edit")
    public String editEmployee(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        EmployeeDto employeeDto = employeeServiceImpl.getEmployeeDtoById(employeeDtoId);
        model.addAttribute("employeeDto", employeeDto);
        return "editEmployee";
    }

//    todo /admin
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

//    todo /admin
    @GetMapping("admin/{employeeDtoId}/delete")
    public String deleteEmployee(@PathVariable("employeeDtoId") Long employeeDtoId) {
        employeeServiceImpl.deleteEmployee(employeeDtoId);
        return "redirect:/admin/employees";
    }

//    todo /admin
    @GetMapping("admin/{employeeDtoId}/details")
    public String showEmployeeDetails(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        EmployeeDto employeeDetailsDto = employeeServiceImpl.getEmployeeDtoById(employeeDtoId);
        model.addAttribute("employeeDetailsDto", employeeDetailsDto);
        return "employeeDetails";
    }

//    todo /manager
    @GetMapping("/manager/{employeeDtoId}/detailsManagersSpace")
    public String showEmployeeDetailsManagersSpace(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        EmployeeDto employeeDetailsDto = employeeServiceImpl.getEmployeeDtoById(employeeDtoId);
        model.addAttribute("employeeDetailsDto", employeeDetailsDto);
        return "employeeDetailsManagersSpace";
    }

}






























