package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//  Remember your annotations

@Controller
public class StoreController {

    @GetMapping ( "/laptop" )   //  Here since you are not returning a view, you need to specify the object you want to return
    @ResponseBody //    Using Postman, this would simply  GET "SurfaceBook 3"
    //  The order of annotation placement matters here
    public String Laptop () {
        return "SurfaceBook 3 ";
    }
}
