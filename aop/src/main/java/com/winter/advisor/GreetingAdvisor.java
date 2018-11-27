package com.winter.advisor;

import com.winter.advice.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

//切点信息：所匹配的类和方法信息
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    //切点方法匹配规则：方法名为greetTo
    public boolean matches(Method method, Class clazz) {
        return "greetTo".equals(method.getName());
    }

    //切点类匹配规则：为Waiter类或其子类
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
