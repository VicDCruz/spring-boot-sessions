package onlineretailer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartServiceImpl implements CartService {
    @Value("${contactEmail}")
    private String email;
    @Value("${onlineRetailer.salesTaxRate}")
    private double salesTaxRate;
    @Value("${onlineRetailer.deliveryCharge.normal}")
    private double normalDeliveryCharge;
    @Value("${onlineRetailer.deliveryCharge.threshold}")
    private int thresholdDeliveryCharge;

    private final HashMap<Integer, Item> catalog;
    private final CartRepository cart;

    public CartServiceImpl(@Qualifier("catalog") HashMap<Integer, Item> catalog, CartRepository cart) {
        this.catalog = catalog;
        this.cart = cart;
    }

    private boolean existsItem(int id) {
        return this.catalog.containsKey(id);
    }

    @Override
    public void addItemToCart(int id, int quantity) {
        if (this.existsItem(id)) {
            this.cart.add(id, quantity);
        }
    }

    @Override
    public void removeItemFromCart(int id) {
        if (this.existsItem(id)) {
            this.cart.remove(id);
        }
    }

    @Override
    public Map<Integer, Integer> getAllItemsInCart() {
        return this.cart.getAll();
    }

    @Override
    public double calculateCartCost() {
        System.out.printf("\tDefault values: [%.2f, %.2f, %s]\n", this.salesTaxRate, this.normalDeliveryCharge, this.thresholdDeliveryCharge);
        double cost = this.cart.getAll()
                .entrySet().stream().mapToDouble(entry -> {
                    Item item = this.catalog.get(entry.getKey());
                    return item.getPrice() * entry.getValue();
                }).sum();
        System.out.println("Email the report to... " + this.email);
        return cost;
    }
}
