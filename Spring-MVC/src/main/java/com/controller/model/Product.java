package com.controller.model;

public class Product {
    //  POJO
    private String name;
    private double price;

    public Product () {}

    public Product ( String name, Double price ) {
        this.name = name;
        this.price = price;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }
}
