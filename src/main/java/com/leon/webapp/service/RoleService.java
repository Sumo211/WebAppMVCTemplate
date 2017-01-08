package com.leon.webapp.service;

import com.leon.webapp.constant.RoleType;
import com.leon.webapp.model.Role;
import com.leon.webapp.repository.CustomRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ntcong on 1/3/2017.
 */
@Service
@Transactional(readOnly = true)
public class RoleService {

    @Autowired
    private CustomRoleRepository roleRepository;

    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    public List<Role> findByType(RoleType type) {
        return roleRepository.findByType(type);
    }

    public Role findOne(long id) {
        return roleRepository.findOne(id);
    }

}
