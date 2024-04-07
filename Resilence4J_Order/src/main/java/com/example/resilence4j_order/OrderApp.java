package com.example.resilence4j_order;


import com.example.resilence4j_order.entities.Orders;
import com.example.resilence4j_order.repos.Orders_Repo;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderApp {
    private final Orders_Repo orderRepository;
    private final Faker faker = new Faker();

    public OrderApp(Orders_Repo orderRepository) {
        this.orderRepository = orderRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run((OrderApp.class));
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                Orders order = createFakeOrder();
                orderRepository.save(order);
            }
        };
    }

    private Orders createFakeOrder() {
        Orders order = new Orders();
        order.setOrdertime(faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
        order.setStatus(Integer.parseInt(faker.lorem().word()));
        order.setShipping_address(Integer.parseInt(faker.address().fullAddress()));
        return order;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
