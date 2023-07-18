package com.ostanin.project31.Boot.service;

import com.ostanin.project31.Boot.models.User;

import java.util.List;

public interface UserService {
    void addUser(String name, String lastname, int age);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(int id, String name, String lastname, int age);
}
