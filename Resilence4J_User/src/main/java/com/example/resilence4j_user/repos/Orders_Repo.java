package com.example.resilence4j_user.repos;

import com.example.resilence4j_user.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Orders_Repo extends JpaRepository<Orders, Long> {
}
