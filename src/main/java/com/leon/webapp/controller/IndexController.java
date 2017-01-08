package com.leon.webapp.controller;

import com.leon.webapp.constant.RoleType;
import com.leon.webapp.model.User;
import com.leon.webapp.service.RoleService;
import com.leon.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ntcong on 12/29/2016.
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("name", "Universe");

        userService.createNewUser(User.builder().email("leon1@gmail.com").password("123456").username("leon43")
                .role(roleService.findOne(2l)).build());
        userService.createNewUser(User.builder().email("leon2@gmail.com").password("123456").username("leon22")
                .role(roleService.findOne(2l)).build());

        System.out.println(roleService.findByType(RoleType.USER).size());

        return "index";
    }

}
