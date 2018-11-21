package com.winter.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MailSenderListener implements ApplicationListener<MailSendEvent> {

    //对MailSendEvent进行处理
    public void onApplicationEvent(MailSendEvent event) {
        MailSendEvent mse = (MailSendEvent)event;
        System.out.println("MailSenderListener:向" + mse.getTo() + "发送完一封邮件");
    }
}
