package com.amsysytem.controller;

import com.amsysytem.dto.RequestDto;
import com.amsysytem.service.RequestServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class RequestController {

    public final RequestServiceImpl requestServiceImpl;

    @GetMapping("/requests")
    public String listRequest(Model model){
        List<RequestDto> requestDtoList = requestServiceImpl.getAllRequests();
        model.addAttribute("requestDtoList", requestDtoList);
        return "requests";
    }

    @GetMapping("/listRequestsAdminMode")
    public String listRequestsAdminMode(Model model){
        List<RequestDto> requestDtoList = requestServiceImpl.getAllRequests();
        model.addAttribute("requestDtoList", requestDtoList);
        return "requests-admin-mode";
    }
}
