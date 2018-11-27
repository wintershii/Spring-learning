package com.winter.advice;

public class NaiveWaiter implements Waiter{

    public void greetTo(String name) {
        System.out.println("greet to" + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("serving to" + name + "...");
    }

    public void greetTosb(String name) {
        System.out.println("you are sb :" + name + "...");
    }
}
