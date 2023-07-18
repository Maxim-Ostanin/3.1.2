package com.ostanin.project31.Boot.dao;


import com.ostanin.project31.Boot.models.User;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(String name, String lastname, int age) {

        User user = new User(name, lastname, age);
        em.persist(user);

    }

    @Override
    public void removeUserById(int id) {

        User user = em.find(User.class, id);
        em.remove(user);

    }

    @Override
    public List<User> getAllUsers() {

        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {

        return em.find(User.class, id);
    }

    @Override
    public void updateUser(int id, String name, String lastname, int age) {

        User user = em.find(User.class, id);
        user.setName(name);
        user.setLastName(lastname);
        user.setAge(age);

    }
}
