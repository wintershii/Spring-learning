package com.winter.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailSender implements ApplicationContextAware {

    private ApplicationContext ctx;

    //容器启动时注入容器实例
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    public void sendMail(String to) {
        System.out.println("MailSender模拟发送邮件...");
        MailSendEvent mse = new MailSendEvent(this.ctx,to);
        //向容器中的所有事件监听器发送事件
        ctx.publishEvent(mse);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("eventbeans.xml");
        MailSender mailSender = (MailSender)ctx.getBean("mailSender");
        mailSender.sendMail("shidongxuan@xiyou3g.com");
    }
}
