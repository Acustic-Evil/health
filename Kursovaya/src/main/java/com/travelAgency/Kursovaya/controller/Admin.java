package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.repository.UserRepository;
import com.travelAgency.Kursovaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public String getExpertsPage(Model model) {
        List<UserSystem> users = userService.getAllByRole("expert");
        model.addAttribute("experts", users);
        return "adm2";
    }

    @GetMapping("/adminList")
    public String getAdminListPage(Model model) {
        List<UserSystem> users = userService.getAllByRole("admin");
        model.addAttribute("adminList", users);
        return "admins";

    }

    @GetMapping("/userList")
    public String getUserListPage(Model model) {
        List<UserSystem> users = userService.getAllByRole("user");
        model.addAttribute("userList", users);
        return "users";
    }

    @GetMapping("/patientList")
    public String getPatientListPage(Model model) {
        List<UserSystem> users = userService.getAllByRole("patient");
        model.addAttribute("patients", users);
        return "patients";
    }

    @PostMapping("/add_expert")
    public String addExpert(@RequestParam(value = "full_name") String full_name, @RequestParam (value = "email") String email, @RequestParam(value = "password") String password, Map<String, Object> model) {
        if (userRepository.findExactPerson(email)){
            return "redirect:/admin/expertList?errorPersExists";
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            UserSystem userSystem = new UserSystem(full_name, email, "expert", bCryptPasswordEncoder.encode(password));

            userRepository.save(userSystem);

            return "redirect:/admin/expertList?success";
        }

    }

    @PostMapping("/add_admin")
    public String addAdmin(@RequestParam(value = "full_name") String full_name, @RequestParam (value = "email") String email, @RequestParam(value = "password") String password, Map<String, Object> model) {
        if (userRepository.findExactPerson(email)){
            return "redirect:/admin/adminList?errorPersExists";
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            UserSystem userSystem = new UserSystem(full_name, email, "admin", bCryptPasswordEncoder.encode(password));

            userRepository.save(userSystem);

            return "redirect:/admin/adminList?success";
        }
    }
    @PostMapping("/promoteUsr/{id}")
    public String promoteUsr(@PathVariable(value="id") Long id) {
        UserSystem userSystem = userRepository.findById(id);
        userSystem.setRoles("patient");
        userRepository.save(userSystem);
        return "redirect:/admin/userList";
    }

    @PostMapping("/deleteUsr/{id}")
    public String deleteUsr(@PathVariable(value="id") Long id) {
        UserSystem userSystem = userRepository.findById(id);
        userRepository.delete(userSystem);
        return "redirect:/admin/userList";
    }

    @PostMapping("/deleteExpert/{id}")
    public String deleteExpert(@PathVariable(value="id") Long id) {
        UserSystem userSystem = userRepository.findById(id);
        userRepository.delete(userSystem);
        return "redirect:/admin/expertList";
    }
    @PostMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable(value="id") Long id) {
        UserSystem userSystem = userRepository.findById(id);
        userRepository.delete(userSystem);
        return "redirect:/admin/adminList";
    }
    @PostMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value="id") Long id) {
        UserSystem userSystem = userRepository.findById(id);
        userRepository.delete(userSystem);
        return "redirect:/admin/patientList";
    }
}
