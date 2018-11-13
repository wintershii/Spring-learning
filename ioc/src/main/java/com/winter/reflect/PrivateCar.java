package com.winter.reflect;


public class PrivateCar {
    private String color;

    protected void drive() {
        System.out.println("drive private car! the car is " + color);
    }
}
