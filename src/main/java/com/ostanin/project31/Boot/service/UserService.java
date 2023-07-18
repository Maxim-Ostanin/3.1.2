package com.ostanin.project31.Boot.service;

import com.ostanin.project31.Boot.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(int id, User user);
}
