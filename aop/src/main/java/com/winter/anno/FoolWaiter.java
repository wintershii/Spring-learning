package com.winter.anno;

import com.winter.advice.Waiter;

public class FoolWaiter implements Waiter {

    public void greetTo(String name) {
        System.out.println("FoolWaiter:greet to" + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("FoolWaiter:serve to" + name + "...");
    }

    public void greetTosb(String name) {
        System.out.println("FoolWaiter:greet to sb:" + name + "...");
    }
}
