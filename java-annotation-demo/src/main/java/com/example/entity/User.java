package com.example.entity;

import com.example.common.annotation.Injection;

public class User {
    private String uuid;
    private String uaerName;
    private String password;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUaerName() {
        return uaerName;
    }

    @Injection(value = "root")
    public void setUaerName(String uaerName) {
        this.uaerName = uaerName;
    }

    public String getPassword() {
        return password;
    }
    @Injection(value = "123456")
    public void setPassword(String password) {
        this.password = password;
    }
}
