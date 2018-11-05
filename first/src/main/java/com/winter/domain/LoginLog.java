package com.winter.domain;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;

    public LoginLog() {
    }

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLpginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public LoginLog(int loginLogId, int userId, String ip, Date loginDate) {
        this.loginLogId = loginLogId;
        this.userId = userId;
        this.ip = ip;
        this.loginDate = loginDate;

    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "loginLogId=" + loginLogId +
                ", userId=" + userId +
                ", ip='" + ip + '\'' +
                ", lpginDate=" + loginDate +
                '}';
    }
}
