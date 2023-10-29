package com.amsysytem.controller;

import com.amsysytem.dto.RequestDto;
import com.amsysytem.enums.Status;
import com.amsysytem.service.RequestServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

//    todo /admin
    @GetMapping("admin/listRequestsAdminMode")
    public String listRequestsAdminMode(Model model) {
        List<RequestDto> requestDtoList = requestServiceImpl.getAllRequests();
        model.addAttribute("requestDtoList", requestDtoList);
        return "requests-admin-mode";
    }

//    todo /manager
    @GetMapping("manager/listRequestsManagerMode")
    public String listRequestsManagerMode(Model model) {
        List<RequestDto> requestDtoList = requestServiceImpl.getAllRequests();
        model.addAttribute("requestDtoList", requestDtoList);
        return "requests-manager-mode";
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

    @GetMapping("/{requestDtoId}/edit")
    public String editRequestAdminMode(@PathVariable("requestDtoId") Long requestDtoId, Model model){
        RequestDto requestDto = requestServiceImpl.getRequestDtoById(requestDtoId);
        model.addAttribute("requestDto", requestDto);
        return "editRequestAdminSpace";
    }

    @PostMapping("/{requestDtoId}")
    public String updateRequest(@PathVariable("requestDtoId") Long requestDtoId,
                                @Valid @ModelAttribute("requestDto") RequestDto requestDto,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("requestDto", requestDto);
            return "editRequestAdminSpace";
        }
        requestDto.setId(requestDtoId);
        requestServiceImpl.updateRequest(requestDto);
        return "redirect:/requests";
    }

    @GetMapping("listRequestsAdminMode/{requestDtoId}/delete")
    public String deleteRequest(@PathVariable("requestDtoId") Long requestDtoId){
        requestServiceImpl.deleteRequest(requestDtoId);
        return "redirect:/requests-admin-mode";
//        todo delete working, mapping not working
    }






















}
