package com.amsysytem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("https://amsystemapp.up.railway.app")
public class HomeController {

    @GetMapping("/login")
    public String login() {
        return "login-page";
    }

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/admin")
    public String getAdminPlace() {
        return "admin";
    }

    @GetMapping("/user")
    public String getUserPlace() {
        return "user";
    }

    @GetMapping("/manager")
    public String getManagerPlace() {
        return "manager";
    }

    @GetMapping("/access-denied")
    public String getAccessDeniedPage() {
        return "access-denied";
    }

}

