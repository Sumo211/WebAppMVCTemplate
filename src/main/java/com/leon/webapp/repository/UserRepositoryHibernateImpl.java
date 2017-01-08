package com.leon.webapp.repository;

import com.leon.webapp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ntcong on 12/30/2016.
 */
@Repository(value = "userRepoHibernate")
@Transactional
public class UserRepositoryHibernateImpl implements UserRepository {

    private SessionFactory sessionFactory;

    /*public UserRepositoryHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/

    @Override
    public User createNewUser(User user) {
        Serializable id = getCurrentSession().save(user);
        User newUser = User.builder().username(user.getUsername()).email(user.getEmail()).password(user.getPassword()).build();
        newUser.setId((Long) id);
        return newUser;
    }

    @Override
    public User findOne(long id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        CriteriaQuery<User> criteria = getCurrentSession().getCriteriaBuilder().createQuery(User.class);
        criteria.select(criteria.from(User.class));
        Query<User> query = getCurrentSession().createQuery(criteria);
        query.setCacheable(false);
        return query.list();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
