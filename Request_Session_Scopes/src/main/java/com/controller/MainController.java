package com.controller;

import com.sun.tools.javac.Main;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.service.LoggedUserManagementService;
@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;

    //  this is a autowired dependency
    public MainController ( LoggedUserManagementService loggedUserManagementService ) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping ( "/main" )
    public String home ( @RequestParam ( required = false ) String logout,
                         Model model ) {
        if ( logout != null ) {
            loggedUserManagementService.setUsername( null );
        }

        String username = loggedUserManagementService.getUsername();
        if ( username == null ) {
            return "redirect:/";
        }
        model.addAttribute( "username", username );
        return "main.html";
    }
}
