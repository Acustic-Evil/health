package com.travelAgency.Kursovaya.controller;


import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {
    @Autowired
    UserService userService;

    @GetMapping("/sign_in")
    public String sendLogin() {
        return "sign_in";
    }

    @GetMapping("/sign_up")
    public String signup() {
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String addNewUsers(@RequestParam(value = "username") String username, @RequestParam(value = "full_name") String full_name, @RequestParam(value = "password") String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!userService.saveUser(new UserSystem(full_name, username, "admin", bCryptPasswordEncoder.encode(password)))) {
            return "redirect:/sign_up";
        }
        System.out.println("New user: " + full_name + "; login: " + username);
        return "redirect:/sign_in";
    }

}
