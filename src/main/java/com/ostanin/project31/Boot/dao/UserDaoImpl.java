package com.ostanin.project31.Boot.dao;


import com.ostanin.project31.Boot.models.User;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);

    }

    @Override
    public void removeUserById(int id) {

        Query<User> query = (Query<User>) em.createQuery("delete from User u where id = :userId");
        query.setParameter("userId", id);
        query.executeUpdate();
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
    public void updateUser(int id, User user) {

        em.merge(user);
    }
}
