package com.amsysytem.controller;

import com.amsysytem.dto.RequestDto;
import com.amsysytem.service.RequestServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("https://amsystemapp.up.railway.app")
public class UserController {

    private final RequestServiceImpl requestServiceImpl;

    @GetMapping("/user/{userDtoId}")
    public String showMyRequestsList(@PathVariable("userDtoId") Long userId, Model model) {
        List<RequestDto> myRequestsList = requestServiceImpl.findRequestsByUserId(userId);
        model.addAttribute("myRequestsList", myRequestsList);
        return "myRequestsList";
    }

    @GetMapping("/user/{requestDtoId}/delete")
    public String deleteMyRequest(@PathVariable("requestDtoId") Long requestDtoId) {
        requestServiceImpl.deleteRequest(requestDtoId);
        return "redirect:https://amsystemapp.up.railway.app/user/myRequestsList";
    }

    @GetMapping("/user/myRequestsList")
    public String myRequestsList(Model model, Principal principal) {
        List<RequestDto> requestDtoList = requestServiceImpl.findRequestsByUserEmail(principal.getName());
        model.addAttribute("requestDtoList", requestDtoList);
        return "myRequestsList";
    }

    @GetMapping("/user/addNewRequest")
    public String addNewRequest(Model model) {
        RequestDto requestDtoToAdd = new RequestDto();
        model.addAttribute("requestDtoToAdd", requestDtoToAdd);
        return "request-form";
    }

    @PostMapping("/saveNewRequest")
    public String saveNewRequest(@Valid @ModelAttribute("requestDtoToAdd") RequestDto requestDto,
                                 BindingResult result,
                                 Model model,
                                 Principal principal) {
        if (result.hasErrors()) {
            model.addAttribute("requestDto", requestDto);
            return "request-form";
        }

        requestServiceImpl.save(requestDto, principal.getName());
        return "redirect:https://amsystemapp.up.railway.app/user/myRequestsList";
    }
}
