package com.example.resilence4j_user.services;

import com.example.resilence4j_user.entities.Users;
import com.example.resilence4j_user.repos.Users_Repo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class Users_Services {
    private final Users_Repo userRepository;

    public Users_Services(Users_Repo userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getListUser(){
        return  userRepository.findAll();
    }

    public Users getUserById(long id){
        return userRepository.findById(id).get();
    }
}
