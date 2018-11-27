package com.winter.advisor;

import com.winter.advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegexpMethodPointcutAdvisorTest {
    public static void main(String[] args) {
        String configPath = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter3");
        waiter.greetTo("shidongxuan");
        waiter.serveTo("shidongxuan");
        waiter.greetTosb("what fuck");
    }
}
