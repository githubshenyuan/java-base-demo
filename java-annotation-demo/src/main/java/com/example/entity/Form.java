package com.example.entity;

import com.example.common.annotation.DateString;

public class Form {
    @DateString
    private String current;
    private User user;

    /**
     * Getter method for property <tt>current</tt>.
     *
     * @return property value of current
     */
    public String getCurrent() {
        return current;
    }

    /**
     * Setter method for property <tt>current</tt>.
     *
     * @param current value to be assigned to property current
     */
    public void setCurrent(String current) {
        this.current = current;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}