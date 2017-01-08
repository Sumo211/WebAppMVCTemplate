package com.leon.webapp.service;

import com.leon.webapp.model.User;

import java.util.List;

/**
 * Created by ntcong on 12/30/2016.
 */
public interface UserService {

    User createNewUser(User user);

    User findOne(long id);

    List<User> findAll();

}
