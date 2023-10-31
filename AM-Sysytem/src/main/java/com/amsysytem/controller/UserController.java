package com.amsysytem.controller;

import com.amsysytem.dto.RequestDto;
import com.amsysytem.entity.Request;
import com.amsysytem.repositories.RequestRepository;
import com.amsysytem.service.EmployeeServiceImpl;
import com.amsysytem.service.RequestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final RequestServiceImpl requestServiceImpl;

    @GetMapping("/user/{userDtoId}")
    public String showMyRequestsList(@PathVariable("userDtoId") Long userId, Model model){
        List<RequestDto> myRequestsList = requestServiceImpl.findRequestsByUserId(userId);
        model.addAttribute("myRequestsList", myRequestsList);
        return "myRequestsList";

    }

}
