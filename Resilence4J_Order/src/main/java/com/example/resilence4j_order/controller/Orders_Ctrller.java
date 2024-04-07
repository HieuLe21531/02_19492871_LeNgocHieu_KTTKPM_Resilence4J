package com.example.resilence4j_order.controller;


import com.example.resilence4j_order.entities.Orders;
import com.example.resilence4j_order.services.Orders_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Orders_Ctrller {
    @Autowired
    private Orders_Services orderService;

    @GetMapping("/orders")
    public List<Orders> getLisOrder(){
        return  orderService.getListOrder();
    }

    @GetMapping("/orders/{id}")
    public Orders getUserById(@PathVariable(value = "id") long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Orders addOrder(@RequestBody Orders order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrder(@PathVariable(value = "orderId") long orderId){
        orderService.deleteOrderById(orderId);
    }
}
