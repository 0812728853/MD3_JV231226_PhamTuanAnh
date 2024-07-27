package com.ra.controller.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String index(){
        return "redirect:/admin/";
    }
    @RequestMapping("/")
    public String admin() {
        return "admin/index";
    }
}
