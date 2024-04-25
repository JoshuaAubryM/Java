package com.controller.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope //    Spring creates a temporary instance that last for the amount of time that the user browses the page
public class LoggedUserManagementService {
    //  It is another DTO
    //  It is a dependency of LoginProcessor AND MainController

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
