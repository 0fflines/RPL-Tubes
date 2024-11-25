package com.example.RPLTubes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        //ini seharusnya kalo belum sign in nyoba ke homepage bakal diarahin ke 
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}