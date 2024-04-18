package com.controller.service;

import java.util.ArrayList;
import java.util.List;
import com.controller.model.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private List <Product> products = new ArrayList<>();
    //  initialize a list that will store the user input

    public void addProduct ( Product p ) {
        products.add ( p );
    }

    public List<Product> findAll () {
        return products;
    }
}
