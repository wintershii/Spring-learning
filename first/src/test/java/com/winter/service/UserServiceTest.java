package com.winter.service;

import org.springframework.beans.factory.annotation.Autowired;

@ContextConfiguration("classpath*:/winter-context.xml")
public class UserServiceTest extends AbstractTransactionT{
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService
    }

    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin","123456");
        boolean b2 = userService.hasMatchUser("admin","1111");

    }
}
