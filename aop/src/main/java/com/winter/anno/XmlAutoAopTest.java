package com.winter.anno;

import com.winter.advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAutoAopTest {
    public static void main(String[] args) {
        String configPath = "aopbeans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        waiter.greetTo("shidongxuan");
        waiter.serveTo("shidongxuan");
    }
}
