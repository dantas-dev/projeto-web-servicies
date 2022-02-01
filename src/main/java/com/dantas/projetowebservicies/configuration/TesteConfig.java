package com.dantas.projetowebservicies.configuration;

import com.dantas.projetowebservicies.model.order.OrderEntity;
import com.dantas.projetowebservicies.model.order.OrderRepository;
import com.dantas.projetowebservicies.model.user.UserEntity;
import com.dantas.projetowebservicies.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        UserEntity user1 = new UserEntity(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        UserEntity user2 = new UserEntity(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(user1, user2));

        OrderEntity order1 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), user1);
        OrderEntity order2 = new OrderEntity(null, Instant.parse("2019-07-21T03:42:10Z"), user2);
        OrderEntity order3 = new OrderEntity(null, Instant.parse("2019-07-22T15:21:22Z"), user1);
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

    }
}
