package com.winter.annotationbean;

import com.winter.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class RealBoss {
    private Car car;

    public RealBoss() {
        System.out.println("Construct...");
    }

    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @PostConstruct
    private void init() {
        System.out.println("execute init...");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("execute destory...");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("beans.xml");
        ((ClassPathXmlApplicationContext)ctx).destroy();
    }
}
