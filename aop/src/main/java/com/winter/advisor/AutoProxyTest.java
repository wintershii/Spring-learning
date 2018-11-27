package com.winter.advisor;

import com.winter.advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoProxyTest {
    public static void main(String[] args) {
        String configPath = "beans2.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller)ctx.getBean("seller");
        waiter.greetTo("John");
        seller.greetTo("shidongxuan");
    }
}
