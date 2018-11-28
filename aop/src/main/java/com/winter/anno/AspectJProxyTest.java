package com.winter.anno;

import com.winter.advice.NaiveWaiter;
import com.winter.advice.Waiter;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.testng.annotations.Test;

public class AspectJProxyTest {
    @Test
    public void proxy() {
        Waiter target = new FoolWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        //设置目标对象
        factory.setTarget(target);
        //添加切面类
        factory.addAspect(PreGreetingAspect.class);
        //生成织入切面的代理对象
        Waiter proxy = factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");
    }
}
