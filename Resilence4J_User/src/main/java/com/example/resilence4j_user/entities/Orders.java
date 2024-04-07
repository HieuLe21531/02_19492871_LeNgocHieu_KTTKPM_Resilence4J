package com.example.resilence4j_user.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private String order_id;
    @Column(name = "ordertime")
    private LocalDateTime ordertime;
    @Column(name = "status")
    private int status;
    @Column(name = "shipping_address")
    private int shipping_address;
    @ManyToOne
    private Users users;

    public Orders(String order_id, LocalDateTime ordertime, int status, int shipping_address) {
        this.order_id = order_id;
        this.ordertime = ordertime;
        this.status = status;
        this.shipping_address = shipping_address;
    }
}
