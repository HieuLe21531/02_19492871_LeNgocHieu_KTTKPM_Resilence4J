package com.example.resilence4j_order.repos;

import com.example.resilence4j_order.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users_Repo extends JpaRepository<Users, Long> {
}
