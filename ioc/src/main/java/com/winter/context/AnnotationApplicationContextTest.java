package com.winter.context;

import com.winter.Car;
import com.winter.beanfactory.Beans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AnnotationApplicationContextTest {
    @Test
    public void getBean() {
        //通过一个带@Configuration的POJO装载Bean配置
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car",Car.class);
        assertNotNull(car);
    }
}
