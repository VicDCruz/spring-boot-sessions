package com.example.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapCartService implements CartService {
    private Map<Integer, Item> catalog;
    private CartRepository cart;

    @Value("${contactEmail}")
    private String contactEmail;
    @Value("${onlineRetailer.salesTaxRate}")
    private double salesTaxRate;
    @Value("${onlineRetailer.deliveryCharge.normal}")
    private double standardDeliveryCharge;
    @Value("${onlineRetailer.deliveryCharge.threshold}")
    private double deliveryChargeThreshold;

    @Autowired
    public MapCartService(Map<Integer, Item> catalog, CartRepository cart) {
        this.catalog = catalog;
        this.cart = cart;
    }

    @Override
    public void addToCart(int itemId, int quantity) {
        if (this.catalog.containsKey(itemId)) this.cart.add(itemId, quantity);
        else System.out.printf("Item #%d does not exist!\n", itemId);
    }

    @Override
    public void removeFromCart(int itemId) {
        this.cart.remove(itemId);
    }

    @Override
    public HashMap<Integer, Integer> getAllItemsInCart() {
        return this.cart.getAll();
    }

    @Override
    public double calculateCartCost() {
        System.out.println(this.salesTaxRate);
        System.out.println(this.standardDeliveryCharge);
        System.out.println(this.deliveryChargeThreshold);
        double cost = this.cart.getAll().entrySet().stream()
                .mapToDouble(i -> this.catalog.get(i.getKey()).getPrice() * i.getValue())
                .sum();
        System.out.printf("Email the report to... %s with [cost: %.2f]\n", this.contactEmail, cost);
        return cost;
    }
}
