package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.models.Laptop;
//  Remember your annotations

@Controller
public class StoreController {

    @GetMapping ( "/laptop" )   //  Here since you are not returning a view, you need to specify the object you want to return
    @ResponseBody //    Using Postman, this would simply  GET "SurfaceBook 3"
    //  The order of annotation placement matters here
    public String Laptop () {
        return "SurfaceBook 3 ";
    }

    @GetMapping ( "/Surface" )
    @ResponseBody
    public Laptop SurfaceBookThree () {
        Laptop laptop =  Laptop.of ( "Surface Book 3" );
        //  Remember when instantiating the object that this is a factory method
        laptop.setName( "Surface Book 3 ");
        return laptop;
        //  This si an extension of the first method. Now instead of just defining the @ResponseBody, within the controller
        //  I have created an instance and then passed it as a response body to the client
        //  In this case, Laptop is a DTO or data transfer object which is used to deliver information across the application.
        //  Laptop -> to Controller Laptop is DTO, controller is an endpoint.
    }
}
