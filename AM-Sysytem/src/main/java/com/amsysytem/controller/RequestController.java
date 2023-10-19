package com.amsysytem.controller;

import com.amsysytem.dto.RequestDto;
import com.amsysytem.enums.Status;
import com.amsysytem.service.RequestServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class RequestController {

    public final RequestServiceImpl requestServiceImpl;

    @GetMapping("/requests")
    public String listRequest(Model model) {
        List<RequestDto> requestDtoList = requestServiceImpl.getAllRequests();
        model.addAttribute("requestDtoList", requestDtoList);
        return "requests";
    }

    @GetMapping("/listRequestsAdminMode")
    public String listRequestsAdminMode(Model model) {
        List<RequestDto> requestDtoList = requestServiceImpl.getAllRequests();
        model.addAttribute("requestDtoList", requestDtoList);
        return "requests-admin-mode";
    }

    @GetMapping("/addNewRequest")
    public String addNewRequest(Model model) {
        RequestDto requestDtoToAdd = new RequestDto();
        model.addAttribute("requestDtoToAdd", requestDtoToAdd);
        return "request-form";
    }

    @PostMapping("/saveNewRequest")
    public String saveNewRequest(@Valid @ModelAttribute("requestDtoToAdd") RequestDto requestDto,
                                 BindingResult result,
                                 Model model) {
        requestDto.setStatus(Status.PENDING);
        if (result.hasErrors()) {
            model.addAttribute("requestDto", requestDto);
            return "request-form";
        }

        requestServiceImpl.save(requestDto);
        return "redirect:/requests";
    }

    @GetMapping("/updateStatus")
    public String updateStatus(@RequestParam Integer id, @RequestParam Status status){
        RequestDto existing = requestServiceImpl.getAllRequests().get(id-1);
        existing.setStatus(status);
        requestServiceImpl.save(existing);
        return "redirect:/requests";
    }






}
