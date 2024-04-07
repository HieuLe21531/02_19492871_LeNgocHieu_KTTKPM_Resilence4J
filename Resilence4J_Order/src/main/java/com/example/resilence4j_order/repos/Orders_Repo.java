package com.example.resilence4j_order.repos;

import com.example.resilence4j_order.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Orders_Repo extends JpaRepository<Orders, Long> {
}
