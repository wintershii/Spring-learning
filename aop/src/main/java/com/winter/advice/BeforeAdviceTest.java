package com.winter.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

public class BeforeAdviceTest {
    @Test
    public void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        //Spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();

        //设置代理目标
        pf.setTarget(target);

        //为代理目标添加增强
        pf.addAdvice(advice);

        Waiter proxy = (Waiter)pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
}
