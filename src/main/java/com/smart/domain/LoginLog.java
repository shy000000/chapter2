package com.smart.domain;

import java.io.Serializable;
import java.util.Date;

//实现序列化接口，数据持久化之需要
public class LoginLog implements Serializable{
    private int loginLogid;
    private int userId;
    private String ip;
    private Date loignDate;

    public int getLoginLogid() {
        return loginLogid;
    }

    public void setLoginLogid(int loginLogid) {
        this.loginLogid = loginLogid;
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

    public Date getLoignDate() {
        return loignDate;
    }

    public void setLoignDate(Date loignDate) {
        this.loignDate = loignDate;
    }
}
