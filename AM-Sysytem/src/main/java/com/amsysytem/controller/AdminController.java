package com.amsysytem.controller;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.dto.RequestDto;
import com.amsysytem.enums.Status;
import com.amsysytem.service.EmployeeServiceImpl;
import com.amsysytem.service.RequestServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("https://amsystemapp.up.railway.app")
public class AdminController {

    private final EmployeeServiceImpl employeeServiceImpl;
    public final RequestServiceImpl requestServiceImpl;

    @GetMapping("/admin/employees")
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

    @PostMapping("/admin/saveNewEmployee")
    public String saveNewEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "addNewEmployee";
        }

        employeeServiceImpl.save(employeeDto);
        return "redirect:https://amsystemapp.up.railway.app/admin/employees";
    }

    @GetMapping("/admin/{employeeDtoId}/edit")
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
        return "redirect:https://amsystemapp.up.railway.app/admin/employees";
    }

    @GetMapping("/admin/{employeeDtoId}/delete")
    public String deleteEmployee(@PathVariable("employeeDtoId") Long employeeDtoId) {
        employeeServiceImpl.deleteEmployee(employeeDtoId);
        return "redirect:https://amsystemapp.up.railway.app/admin/employees";
    }

    @GetMapping("/admin/{employeeDtoId}/details")
    public String showEmployeeDetails(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        EmployeeDto employeeDetailsDto = employeeServiceImpl.getEmployeeDtoById(employeeDtoId);
        model.addAttribute("employeeDetailsDto", employeeDetailsDto);
        return "employeeDetails";
    }

    @GetMapping("/admin/listRequestsAdminMode")
    public String listRequestsAdminMode(Model model) {
        List<RequestDto> requestDtoList = requestServiceImpl.getAllRequests();
        model.addAttribute("requestDtoList", requestDtoList);
        return "requestsAdminMode";
    }

    @GetMapping("/listRequestsAdminMode/{requestDtoId}/edit")
    public String editRequestAdminMode(@PathVariable("requestDtoId") Long requestDtoId, Model model) {
        RequestDto requestDto = requestServiceImpl.getRequestDtoById(requestDtoId);
        model.addAttribute("requestDto", requestDto);
        return "editRequestAdminSpace";
    }

    @PostMapping("/admin/updateRequest/{requestDtoId}")
    public String updateRequest(@PathVariable("requestDtoId") Long requestDtoId,
                                @Valid @ModelAttribute("requestDto") RequestDto requestDto,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("requestDto", requestDto);
            return "editRequestAdminSpace";
        }
        requestDto.setId(requestDtoId);
        requestServiceImpl.updateRequest(requestDto);
        return "redirect:https://amsystemapp.up.railway.app/admin/listRequestsAdminMode";
    }

    @GetMapping("/admin/listRequestsAdminMode/{requestDtoId}/delete")
    public String deleteRequest(@PathVariable("requestDtoId") Long requestDtoId) {
        requestServiceImpl.deleteRequest(requestDtoId);
        return "redirect:https://amsystemapp.up.railway.app/admin/listRequestsAdminMode";
    }

    @ModelAttribute("Status")
    public Status[] selectStatus() {
        return Status.values();
    }
}
