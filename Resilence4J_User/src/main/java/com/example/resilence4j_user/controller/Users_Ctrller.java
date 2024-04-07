package com.example.resilence4j_user.controller;

import com.example.resilence4j_user.entities.Users;
import com.example.resilence4j_user.services.Users_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Users_Ctrller {
    @Autowired
    private Users_Services userService;

    @GetMapping("/users")
    List<Users> getListUser(){
        return  userService.getListUser();
    }
    @GetMapping("/users/{id}")
    Users getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
}
