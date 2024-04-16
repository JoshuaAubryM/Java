package com.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class MainController {

    @RequestMapping ( "/LeafHome/{color}")
    //  Must define the pathvariable within @RequestMapping annotation
    public String getHome ( @PathVariable String color, Model page ) {
     // ------------ use path variables sparingly. What you can and can't do with them is intuitive --------------- //

        page.addAttribute( "color", color);
        page.addAttribute ( "username", "Joshua");
        return "LeafHome.html";
    }
}
