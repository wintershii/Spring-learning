package com.winter.proxy;

public class PerformanceMonitor {

    //通过一个ThreadLocal保存与线程相关的性能监视信息
    private static ThreadLocal<MethodPerformance> performanceRecord =
                                new ThreadLocal<MethodPerformance>();

    //启动对某一目标方法的监视
    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end() {
        System.out.println("end monitor...");
        MethodPerformance mp = performanceRecord.get();

        //打印出性能监视的结果信息
        mp.printPerformance();
    }
}
