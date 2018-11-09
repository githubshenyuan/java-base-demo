package com.example.service;

public interface UserService {
    public void saveUser(String username);


    public String getUser(String username);

    public String updateUser(String oldUsername, String newUsername);


}
