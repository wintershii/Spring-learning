package com.winter.factory;

import com.winter.Boss;

public class BossFactory {
    public static Boss createBigBoss() {
        Boss boss = new Boss();
        boss.setName("师东璇");
        boss.setSalary(123456);
        return boss;
    }
}
