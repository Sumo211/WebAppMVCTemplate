package com.leon.webapp.repository;

import com.leon.webapp.constant.RoleType;
import com.leon.webapp.model.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ntcong on 12/30/2016.
 */
public interface CustomRoleRepository extends CrudRepository<Role, Long> {

    @EntityGraph(value = "graph.Users", type = EntityGraph.EntityGraphType.LOAD)
    List<Role> findByType(RoleType type);

}
