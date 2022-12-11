package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.repository.UserRepository;
import com.travelAgency.Kursovaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Admin {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String getAdminPage() {return "amd";}

    @GetMapping("/expertList")
    public String getExpertsPage() {
        userRepository.findByRoles("expert");

        return "adm2";

    }

    @GetMapping("/adminList")
    public String getAdminListPage() {
        userRepository.findByRoles("admin");

        return "admins";

    }

    @GetMapping("/userList")
    public String getUserListPage() {
        userRepository.findByRoles("user");

        return "users";

    }




}
