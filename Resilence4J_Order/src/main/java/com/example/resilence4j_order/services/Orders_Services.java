package com.example.resilence4j_order.services;


import com.example.resilence4j_order.entities.Orders;
import com.example.resilence4j_order.entities.Users;
import com.example.resilence4j_order.repos.Orders_Repo;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class Orders_Services {
    private final Orders_Repo orderRepository;

    private final RestTemplate restTemplate;


    public Orders_Services(Orders_Repo orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @Retry(name = "retryApi")
    public List<Orders> getListOrder(){
        List<Orders> orderList = orderRepository.findAll();
        for (Orders o: orderList) {
            Users user = restTemplate.getForObject("http://localhost:8082/api/v1/users/"+o.getOrder_id(), Users.class);
            o.setUsers(user);
        }
        return orderList;
    }

    public Orders getOrderById(long id){
        Orders order = orderRepository.findById(id).get();
        Users user = restTemplate.getForObject("http://localhost:8082/api/v1/users/"+id, Users.class);
        order.setUsers(user);
        return order;
    }

    public Orders addOrder(Orders order){
        return orderRepository.save(order);
    }

    public void deleteOrderById(long id){
        orderRepository.deleteById(id);
    }
}
