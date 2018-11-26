package com.winter.cglibproxy;

import com.winter.proxy.ForumServiceImpl;
import org.testng.annotations.Test;

public class ForumServiceTest2 {
    @Test
    public void proxy() {
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService =
                (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
