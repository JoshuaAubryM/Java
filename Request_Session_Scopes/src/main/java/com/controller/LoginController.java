package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import com.controller.service.LoginProcessor;

@Controller
@RequestScope
public class LoginController {
    private final LoginProcessor loginProcessor;

    //  autowire login processor bean
    public LoginController ( LoginProcessor loginProcessor ) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping ( "/" )
    public String loginGet () {
        return "login.html";
    }

    @PostMapping ( "/" )
    public String loginPost ( @RequestParam String username,
                              @RequestParam String password,
                              Model model ) {

        loginProcessor.setUsername( username );
        loginProcessor.setPassword( password );
        //  This is the RequestScope. The user will be authenticated here
        boolean loggedIn = loginProcessor.login();
        //  boolean loggedIn = false;
        //  Because the user is not yet logged in
        //  need a bean that test login credentials
        if ( loggedIn ) {
            //  This is authorization. The login processor needs to pass the info to a service that authorizes the user
            //  will always be false for now so will always return "Login Failed"
            //  model.addAttribute ( "message", "You are logged in." );
            return "redirect:/main";
        }
            model.addAttribute("message", "Login failed!");
            return "login.html";
    }

}
