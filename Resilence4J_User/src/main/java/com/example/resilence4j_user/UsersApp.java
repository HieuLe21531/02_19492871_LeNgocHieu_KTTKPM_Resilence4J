package com.example.resilence4j_user;

import com.example.resilence4j_user.entities.Users;
import com.example.resilence4j_user.repos.Users_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsersApp {
    @Autowired
    private Users_Repo userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UsersApp.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                for (int i=1; i<=10; i++){
                    userRepository.save(new Users(Integer.toString(i), "User" + i));
                }
            }
        };
    }
}
