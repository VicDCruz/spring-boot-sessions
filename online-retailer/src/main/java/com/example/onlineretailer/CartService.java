package com.example.onlineretailer;

import java.util.HashMap;

public interface CartService {
    void addToCart(int itemId, int quantity);

    void removeFromCart(int itemId);

    HashMap<Integer, Integer> getAllItemsInCart();

    double calculateCartCost();
}
