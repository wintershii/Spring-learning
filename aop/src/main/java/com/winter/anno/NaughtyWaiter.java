package com.winter.anno;

import com.winter.advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NaughtyWaiter implements Waiter {

    @NeedTest
    public void greetTo(String name) {
        System.out.println("NaughtyWaiter:greet to " + name + "...");
    }

    public void serveTo(String name) {

    }

    public void greetTosb(String name) {

    }

    public static void main(String[] args) {
        String path = "anno.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        Waiter naiveWaiter = (Waiter)ctx.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter)ctx.getBean("naughtyWaiter");

        naiveWaiter.greetTo("xixi");
        naughtyWaiter.greetTo("shidongxuan");
    }
}
