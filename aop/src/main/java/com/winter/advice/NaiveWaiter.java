package com.winter.advice;

public class NaiveWaiter implements Waiter{

    public void greeTo(String name) {
        System.out.println("greet to" + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("serving to" + name + "...");
    }
}
