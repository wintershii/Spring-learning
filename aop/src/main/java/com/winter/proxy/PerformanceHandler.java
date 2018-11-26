package com.winter.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {
    //target为目标业务类
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(
                target.getClass().getName()+ "." + method.getName());
        //通过反射方法调用业务类的目标方法
        Object obj = method.invoke(target,args);
        PerformanceMonitor.end();
        return obj;
    }
}
