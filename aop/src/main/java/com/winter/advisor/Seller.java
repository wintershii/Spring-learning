package com.winter.advisor;

import com.winter.advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 需要增强的目标类
 */
public class Seller {
    public void greetTo(String name) {
        System.out.println("seller greet to " + name + "...");
    }

    public static void main(String[] args) {
        String configPath = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter2");
        Seller seller = (Seller)ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }
}
