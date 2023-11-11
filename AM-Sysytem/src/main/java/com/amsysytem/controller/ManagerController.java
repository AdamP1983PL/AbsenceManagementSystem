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

    @GetMapping("/manager/listRequestsManagerMode")
    public String listRequestsManagerMode(Model model) {
        List<RequestDto> requestDtoList = requestServiceImpl.getAllRequests();
        model.addAttribute("requestDtoList", requestDtoList);
        return "requestsManagerMode";
    }

    @GetMapping("/listRequestsManagerMode/{requestDtoId}/edit")
    public String editRequestByManager(@PathVariable("requestDtoId") Long requestDtoId, Model model) {
        RequestDto requestDto = requestServiceImpl.getRequestDtoById(requestDtoId);
        model.addAttribute("requestDto", requestDto);
        return "editRequestByManager";
    }

    @PostMapping("/manager/updateRequest/{requestDtoId}")
    public String updateRequestByManager(@PathVariable("requestDtoId") Long requestDtoId,
                                         @Valid @ModelAttribute("requestDto") RequestDto requestDto,
                                         BindingResult result,
                                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("requestDto", requestDto);
            return "editRequestByManager";
        }
        requestDto.setId(requestDtoId);
        requestServiceImpl.updateRequestByManager(requestDto);
        return "redirect:/manager/listRequestsManagerMode";
    }

    @GetMapping("/updateStatus")
    public String updateStatus(@RequestParam Long id, @RequestParam Status status) {
        RequestDto requestDto = requestServiceImpl.getRequestDtoById(id);
        requestDto.setStatus(status);
        requestServiceImpl.updateStatus(requestDto);
        return "redirect:/manager/listRequestsManagerMode";
    }
}




























