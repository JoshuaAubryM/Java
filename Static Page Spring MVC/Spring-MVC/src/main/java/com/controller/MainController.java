package com.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @RequestMapping ( "/Home")
    public String getHome () {

        return "Home.html";
    }
}
