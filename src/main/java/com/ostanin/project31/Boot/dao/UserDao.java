package com.ostanin.project31.Boot.dao;


import com.ostanin.project31.Boot.models.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(int id, User user);

}
