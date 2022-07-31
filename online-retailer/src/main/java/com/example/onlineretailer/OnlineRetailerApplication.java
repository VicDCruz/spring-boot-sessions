package com.example.onlineretailer;

import com.example.onlineretailer.entities.Item;
import com.example.onlineretailer.services.CartService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class OnlineRetailerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineRetailerApplication.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(OnlineRetailerApplication.class, args);
/*        CartService cartService = context.getBean(CartService.class);
        cartService.addToCart(1, 1);
        cartService.addToCart(4, 2);
        cartService.addToCart(3, 3);
        cartService.addToCart(8, 4);
        cartService.addToCart(46, 5); // Doesn't exist
        printCartItems(cartService);
        System.out.printf("Total cost: %.2f\n", cartService.calculateCartCost());
*/
    }

    private static void printCartItems(CartService cartService) {
        cartService.getAllItemsInCart().forEach((key, value) -> System.out.printf("[itemId: %d, quantity: %d]\n", key, value));
    }

    @Bean
    public Map<Integer, Item> catalog() {
        HashMap<Integer, Item> items = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int index = i + 1;
            items.put(index, new Item(index, "Test item #" + index, index * 10));
        }
        return items;
    }
}
