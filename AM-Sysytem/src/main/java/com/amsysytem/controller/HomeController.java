package com.amsysytem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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

}

//    @GetMapping("/logout")
//    public String logout() {
//        return "login";
//    }
