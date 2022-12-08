package com.travelAgency.Kursovaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPage {
    @GetMapping("/")
    public String getMainPage(){
        return "index";
    }

    @GetMapping("/index_auth")
    public String getMainAuthPage(){return "index_auth";}

    @GetMapping("/articles")
    public String getArticlesPage(){
        return "articles";
    }

    @GetMapping("/Alko")
    public String getAlkoPage(){
        return "Alko";
    }

    @GetMapping("/back")
    public String getBackPage(){
        return "back";
    }

    @GetMapping("/stomac")
    public String getStomacPage(){
        return "stomac";
    }

    @GetMapping("/headache")
    public String getHeadachePage(){
        return "headache";
    }

    @GetMapping("/contacts")
    public String getContactsPage(){return "contacts";}

}
