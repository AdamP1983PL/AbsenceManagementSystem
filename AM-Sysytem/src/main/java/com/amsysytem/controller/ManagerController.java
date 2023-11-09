package com.amsysytem.controller;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.dto.RequestDto;
import com.amsysytem.repositories.RequestRepository;
import com.amsysytem.service.EmployeeServiceImpl;
import com.amsysytem.service.RequestServiceImpl;
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
    private final RequestServiceImpl requestServiceImpl;

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

    @GetMapping("/manager/{employeeDtoId}/singleList")
    public String showOneUserRequestsList(@PathVariable("employeeDtoId") Long employeeDtoId, Model model) {
        List<RequestDto> oneUserRequestsList = requestServiceImpl.findRequestsByEmployeeId(employeeDtoId);
        model.addAttribute("oneUserRequestsList", oneUserRequestsList);
        return "oneUserRequestsList";
    }

}

//todo change camelCase in html names


//    @GetMapping("/employees-managers-list")
//    public String listEmployeesManagerMode(Model model){
//        List<EmployeeDto> employeeDtoList = employeeServiceImpl.getAllEmployees();
//        model.addAttribute("employeeDtoList", employeeDtoList);
//        return "employees-manager-mode";
//    }



























