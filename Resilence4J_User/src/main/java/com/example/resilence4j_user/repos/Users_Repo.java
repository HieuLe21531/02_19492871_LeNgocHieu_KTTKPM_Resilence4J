package com.example.resilence4j_user.repos;

import com.example.resilence4j_user.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users_Repo extends JpaRepository<Users, Long> {
}
