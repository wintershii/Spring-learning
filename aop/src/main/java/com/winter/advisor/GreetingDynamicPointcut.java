package com.winter.advisor;

import com.winter.advice.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<String>();
    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> aClass) {
                System.out.println("调用getClassFilter()对" + aClass.getName() +
                        "做静态检查");
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }

    @Override
    public boolean matches(Method method, Class<?> clazz) {
        System.out.println("调用matches(method,clazz)" + clazz.getName() + "." +
                method.getName() + "做静态检查");
        return method.getName().equals("greetTo");
    }

    public boolean matches(Method method, Class<?> clazz, Object... args) {
        System.out.println("调用matches(method,clazz,args)" + clazz.getName() + "." +
                method.getName() + "做动态检查");
        String clientName = (String)args[0];
        return specialClientList.contains(clientName);
    }

    public static void main(String[] args) {
        String configPath = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter4");
        waiter.greetTo("John");
        waiter.greetTo("shidongxuan");
    }

}
