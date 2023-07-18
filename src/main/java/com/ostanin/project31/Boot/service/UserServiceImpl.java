package com.ostanin.project31.Boot.service;

import com.ostanin.project31.Boot.dao.UserDao;
import com.ostanin.project31.Boot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Transactional
    @Override
    public void addUser(String name, String lastname, int age) {
        userDaoImpl.addUser(name, lastname, age);
    }
    @Transactional
    @Override
    public void removeUserById(int id) {
        userDaoImpl.removeUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDaoImpl.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(int id) {
        return userDaoImpl.getUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(int id, String name, String lastname, int age) {
        userDaoImpl.updateUser(id, name, lastname, age);
    }
}
