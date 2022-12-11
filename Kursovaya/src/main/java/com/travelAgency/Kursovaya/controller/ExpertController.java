package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ExpertController {
    @Autowired
    private UserRepository userRepo;

    @PostMapping("/add_expert")
    public String addUser(@RequestParam(value = "full_name") String full_name, @RequestParam (value = "email") String email, @RequestParam(value = "password") String password, Map<String, Object> model) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        UserSystem userSystem = new UserSystem(full_name, email, "expert", bCryptPasswordEncoder.encode(password));

        userRepo.save(userSystem);

        return "redirect:/admin/experts";
    }

}
