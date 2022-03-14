package onlineretailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        CartService cart = context.getBean(CartService.class);
        addItemsToCart(cart);
        System.out.println("Total cost: $" + cart.calculateCartCost());
    }

    private static void addItemsToCart(CartService cart) {
        for (int i = 0; i < 10; i++) {
            int id = (int) (Math.random() * 10);
            int quantity = (int) (Math.random() * 100);
            cart.addItemToCart(id, quantity);
        }
        System.out.println(cart.getAllItemsInCart());
    }

    @Bean
    public HashMap<Integer, Item> catalog() {
        HashMap<Integer, Item> catalog = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            catalog.put(i, new Item(i, "Product # " + i, i * 10.00));
        }
        return catalog;
    }
}
