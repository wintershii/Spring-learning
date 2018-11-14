package com.winter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

//管理Bean生命周期的接口
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public void introduce() {
        System.out.println("这是一辆" + brand + "汽车,颜色是" + color + ",最大速度为" + maxSpeed);
    }

    public Car() {
        System.out.println("调用Car()构造函数");
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    //BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    //BeanNameAware接口方法
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    //DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy()");
    }

    //InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()");
    }

    //通过bean的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("调用init-method所指定的myInit(),将maxSpeed设置为240");
        this.maxSpeed = 240;
    }

    //通过bean的destroy-method属性指定的销毁方法
    public void myDestroy() {
        System.out.println("调用destroy-method所指定的myDestroy()");
    }
}
