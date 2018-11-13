package com.winter.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射获取私有属性和protected方法
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.winter.reflect.PrivateCar");
        PrivateCar pcar = (PrivateCar)clazz.newInstance();
        Field colorField = clazz.getDeclaredField("color");

        colorField.setAccessible(true);
        colorField.set(pcar,"红色");

        Method driveMtd = clazz.getDeclaredMethod("drive");

        driveMtd.setAccessible(true);
        driveMtd.invoke(pcar,(Object[])null);
    }

}
