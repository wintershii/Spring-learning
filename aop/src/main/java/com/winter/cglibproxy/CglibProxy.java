package com.winter.cglibproxy;

import com.winter.proxy.PerformanceMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    //拦截弗雷所有方法的调用
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
        //通过代理类调用父类中的方法
        Object result = proxy.invokeSuper(obj,args);
        PerformanceMonitor.end();
        return result;
    }
}
