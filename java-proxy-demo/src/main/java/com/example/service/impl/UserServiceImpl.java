package com.example.service.impl;

import com.example.service.UserService;

public class UserServiceImpl implements UserService {
    public void saveUser(String username) {
        System.out.println("添加用户：" + username);
    }

    public String getUser(String username) {
        System.out.println("查询用户：" + username);
        return username;
    }

    public String updateUser(String oldUsername, String newUsername) {
        System.out.println("更新用户：" + oldUsername + " 为：" + newUsername);
        return newUsername;
    }

}
