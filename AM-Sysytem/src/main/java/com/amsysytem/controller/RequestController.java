package com.amsysytem.controller;

import com.amsysytem.dto.RequestDto;
import com.amsysytem.enums.Status;
import com.amsysytem.service.RequestServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @GetMapping("user/myRequestsList")
    public String myRequestsList(Model model, Principal principal) {
        List<RequestDto> requestDtoList = requestServiceImpl.findRequestsByUserEmail(principal.getName());
        model.addAttribute("requestDtoList", requestDtoList);
        return "myRequestsList";
    }

    @GetMapping("admin/listRequestsAdminMode")
    public String listRequestsAdminMode(Model model) {
        List<RequestDto> requestDtoList = requestServiceImpl.getAllRequests();
        model.addAttribute("requestDtoList", requestDtoList);
        return "requestsAdminMode";
    }

    @GetMapping("/manager/listRequestsManagerMode")
    public String listRequestsManagerMode(Model model) {
        List<RequestDto> requestDtoList = requestServiceImpl.getAllRequests();
        model.addAttribute("requestDtoList", requestDtoList);
        return "requestsManagerMode";
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
        return "redirect:/user/myRequestsList";
    }

    @GetMapping("/updateStatus")
    public String updateStatus(@RequestParam Long id, @RequestParam Status status) {
        RequestDto requestDto = requestServiceImpl.getRequestDtoById(id);
        requestDto.setStatus(status);
        requestServiceImpl.updateStatus(requestDto);
        return "redirect:/manager/listRequestsManagerMode";
    }

    @GetMapping("/{requestDtoId}/edit")
    public String editRequestAdminMode(@PathVariable("requestDtoId") Long requestDtoId, Model model) {
        RequestDto requestDto = requestServiceImpl.getRequestDtoById(requestDtoId);
        model.addAttribute("requestDto", requestDto);
        return "editRequestAdminSpace";
    }

    @PostMapping("/admin/{requestDtoId}")
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
        return "redirect:/requests";
    }

    @GetMapping("listRequestsAdminMode/{requestDtoId}/delete")
    public String deleteRequest(@PathVariable("requestDtoId") Long requestDtoId) {
        requestServiceImpl.deleteRequest(requestDtoId);
        return "redirect:/requests-admin-mode";
    }

    @GetMapping("/user/{requestDtoId}/edit")
    public String editMyRequest(@PathVariable("requestDtoId") Long requestDtoId, Model model) {
        RequestDto requestDto = requestServiceImpl.getRequestDtoById(requestDtoId);
        model.addAttribute("requestDto", requestDto);
        return "editMyRequest";
    }

    @PostMapping("user/{requestDtoId}")
    public String updateMyRequest(@PathVariable("requestDtoId") Long requestDtoId,
                                  @Valid @ModelAttribute("requestDtoId") RequestDto requestDto,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("requestDto", requestDto);
            return "editMyRequest";
        }
        requestDto.setId(requestDtoId);
        requestServiceImpl.updateRequest(requestDto);
        return "redirect:/index";
    }

    @GetMapping("/user/{requestDtoId}/delete")
    public String deleteMyRequest(@PathVariable("requestDtoId") Long requestDtoId) {
        requestServiceImpl.deleteRequest(requestDtoId);
        return "redirect:/user/myRequestsList";
    }
}
