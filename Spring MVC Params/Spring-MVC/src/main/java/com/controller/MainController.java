package com.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class MainController {

    @RequestMapping ( "/LeafHome")
    public String getHome ( @RequestParam String color, @RequestParam String name, Model page ) {
        // --------------- Request Parameters take input from the user within the URL path -------------- //
        // --------------- Format: localhost:8080/color=red&&name=joshua --------------- //

        page.addAttribute( "color", color);
        page.addAttribute ( "username", name);
        return "LeafHome.html";
    }
}
