package com.leon.webapp.service;

import com.leon.webapp.model.User;
import com.leon.webapp.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ntcong on 12/30/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    /*private UserRepository userRepository;

    public UserServiceImpl(@Qualifier("userRepoJPA") UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @Autowired
    private CustomUserRepository userRepository;

    @Override
    public User findOne(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }

}
