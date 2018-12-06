package com.winter.aspect;

import com.winter.advice.Waiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Aspect
public class TestAspect {
    @Around("execution(* greetTo(..)) && target(com.winter.advice.NaiveWaiter)")
    public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("----joinPointAccess----");

        System.out.println("args[0]" + pjp.getArgs()[0]);
        System.out.println("signature:" + pjp.getTarget().getClass());
        pjp.proceed();
        System.out.println("----joinPointAccess----");
    }

    public static void main(String[] args) {
        String path = "anno.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        Waiter waiter = (Waiter)ctx.getBean("naiveWaiter");
        waiter.greetTo("shidongxuan");
    }
}
