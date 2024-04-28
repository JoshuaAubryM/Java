package com.controller.models;

public class Laptop {
    //  This is a DTO (Data Transfer Object)
    private String name;

    //  This is a facotry method that helps in the creatioon of Laptops
    public static Laptop of ( String name ) {
        //  What is a factory method?
        //  A factory method allows a class to defer instantiation to a subclass
        //  For the sake of the example, the factory method removes the need to autowire a controller dependency;
        //  public StoreController ( LaptopService laptopService ) { this.laptopService = laptopService }

        Laptop laptop = new Laptop ();
        laptop.setName ( name );
        return laptop;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
