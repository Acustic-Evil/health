package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.entity.Admins;
import com.travelAgency.Kursovaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class Admin {

    @GetMapping("")
    public String getAdminPage() {return "foradm";}

    @GetMapping("/sign_up")
    public String getSignPage() {return "sign_up";}

    @Autowired
    UserService userService;

    @PostMapping("/sign_up")
    public String addNewUsers(@RequestParam(value = "username")String username, @RequestParam(value = "password")String password, @RequestParam(value = "role", required = false)String role){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!userService.saveUser(new Admins("admin", username, bCryptPasswordEncoder.encode(password)))){
            return "redirect:/admin/sign_up";
        }
        System.out.println("New user: "+username + " " +role);
        return "redirect:/admin";
    }
}
