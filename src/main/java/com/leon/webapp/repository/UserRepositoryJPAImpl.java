package com.leon.webapp.repository;

import com.leon.webapp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ntcong on 12/30/2016.
 */
@Repository(value = "userRepoJPA")
@Transactional
public class UserRepositoryJPAImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User createNewUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User findOne(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        Query query = entityManager.createQuery("SELECT * FROM user");
        return query.getResultList();
    }

}
