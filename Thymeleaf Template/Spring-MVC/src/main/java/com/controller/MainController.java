package com.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class MainController {

    @RequestMapping ( "/LeafHome")
    public String getHome ( Model page ) {

        page.addAttribute( "color", "red");
        page.addAttribute ( "username", "Joshua");
        return "LeafHome.html";
    }
}
