package com.controller;

import com.controller.model.Product;
import com.controller.service.ProductService;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController ( ProductService productService ) {
        this.productService = productService;
    }

    @GetMapping ( "/LeafHome" )
    //  @RequestMapping ( "/LeafHome" ) retrieves the page as well
    public String viewProducts ( Model model ) {

        var products = productService.findAll ();

        model.addAttribute ( "products", products );

        return "LeafHome.html";

    }

    @PostMapping ( "/LeafHome" )
    //  @RequestMapping ( path = "/LeafHome", method = RequestMethod.POST )
    public String addProduct (
            @RequestParam String name,
            @RequestParam double price,
            Model model ) {
        //  The parameters request user input through @RequestParam. Without the form in template
        //  You cannot use the interface to accept user input; you have to use URL parameters

        Product p = new Product ();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct( p );

        var products = productService.findAll();
        //  grab all objects in the products list and post them to the view
        model.addAttribute ( "products", products );

        return "LeafHome.html";
    }
}
