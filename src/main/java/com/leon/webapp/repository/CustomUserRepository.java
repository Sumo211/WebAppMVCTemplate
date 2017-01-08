package com.leon.webapp.repository;

import com.leon.webapp.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ntcong on 12/30/2016.
 */
public interface CustomUserRepository extends CrudRepository<User, Long> {

}
