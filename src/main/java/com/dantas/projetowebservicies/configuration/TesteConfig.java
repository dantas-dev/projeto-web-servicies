package com.dantas.projetowebservicies.configuration;

import com.dantas.projetowebservicies.model.category.CategoryEntity;
import com.dantas.projetowebservicies.model.category.CategoryRepository;
import com.dantas.projetowebservicies.model.order.OrderEntity;
import com.dantas.projetowebservicies.model.order.OrderItemEntity;
import com.dantas.projetowebservicies.model.order.OrderItemRepository;
import com.dantas.projetowebservicies.model.order.OrderRepository;
import com.dantas.projetowebservicies.model.order.enums.OrderStatus;
import com.dantas.projetowebservicies.model.product.ProductEntity;
import com.dantas.projetowebservicies.model.product.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        CategoryEntity category1 = new CategoryEntity(null, "Electronics");
        CategoryEntity category2 = new CategoryEntity(null, "Books");
        CategoryEntity category3 = new CategoryEntity(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        ProductEntity product1 = new ProductEntity(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        ProductEntity product2 = new ProductEntity(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        ProductEntity product3 = new ProductEntity(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        ProductEntity product4 = new ProductEntity(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        ProductEntity product5 = new ProductEntity(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        product1.getCategories().add(category2);
        product2.getCategories().addAll(Arrays.asList(category1, category3));
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        UserEntity user1 = new UserEntity(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        UserEntity user2 = new UserEntity(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(user1, user2));

        OrderEntity order1 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID , user1);
        OrderEntity order2 = new OrderEntity(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT , user2);
        OrderEntity order3 = new OrderEntity(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT , user1);
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        OrderItemEntity orderItemEntity1 = new OrderItemEntity(order1, product1, 2, product1.getPrice());
        OrderItemEntity orderItemEntity2 = new OrderItemEntity(order1, product3, 1, product3.getPrice());
        OrderItemEntity orderItemEntity3 = new OrderItemEntity(order2, product3, 2, product3.getPrice());
        OrderItemEntity orderItemEntity4 = new OrderItemEntity(order3, product5, 2, product5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(orderItemEntity1, orderItemEntity2, orderItemEntity3, orderItemEntity4));


    }
}
