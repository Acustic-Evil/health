package com.travelAgency.Kursovaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPage {
    @GetMapping("")
    public String getMainPage(){
        return "index";
    }

    @GetMapping("/bar")
    public String getBarPage(){return "bar";}

    @GetMapping("/basik")
    public String getBasikPage(){return "basik";}

    @GetMapping("/bron")
    public String getBronPage(){return "bron";}

    @GetMapping("/clubbar")
    public String getClubBarPage(){return "clubbar";}

    @GetMapping("/deluxe")
    public String getDeluxePage(){return "deluxe";}

    @GetMapping("/hall")
    public String getHallPage(){return "hall";}

    @GetMapping("/lux")
    public String getLuxPage(){return "lux";}

    @GetMapping("/luxewith")
    public String getLuxeWithPage(){return "luxewith";}

    @GetMapping("/veranda")
    public String getVerandaPage(){return "veranda";}

    @GetMapping ("/about")
    public String getAboutPage(){return "about";}
}
