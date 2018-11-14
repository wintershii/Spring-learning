package com.winter.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor extends
        InstantiationAwareBeanPostProcessorAdapter {

    //接口方法，在实例化Bean后调用
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName)
        throws BeansException {

        if ("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor." +
                    "postProcessBeforeInstantiation");

        }
        return null;
    }

    //接口方法,再试梨花Bean后调用
    public boolean postProcessAfterInstantiation(Object bean, String beanName) {

        if ("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor.postProcess" +
                    "AfterInstantiation");
        }
        return true;
    }

    //接口方法：在设置某个属性值时调用
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) {

        if ("car".equals(beanName)) {
            System.out.println("Instantiation AwareBeanPostProcessor." +
                    "postProcess PropertyValues");
        }
        return pvs;
    }
}
