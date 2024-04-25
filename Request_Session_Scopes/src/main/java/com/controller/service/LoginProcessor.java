package com.controller.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope //    Spring is going to create a single instance of login processsor each time a user logs in
public class LoginProcessor {
    //  This is actually a DTO
    private final LoggedUserManagementService loggedUserManagementService;
    private String username;
    private String password;

    //  autowired the bean. Spring knows to retrieve the instance from context
    public LoginProcessor ( LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }
    public boolean login () {
        String username = this.getUsername();
        String password = this.getPassword();

        //  new boolean
        boolean loginResult = false;
        if ( "joshua".equals( username ) && "password".equals( password ) ) {
            loginResult = true;
            loggedUserManagementService.setUsername( username );
            //  sends username to be authorized in the LoggedUserManagementService
            //  return true;
            //  prototype imnplementation^
        } //else {
            //return false
            //  return false;
            //  prototype implementation^
            //  these return values will change if the initial tests pass
        //}
        //  no more else statement
        return loginResult;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

}
