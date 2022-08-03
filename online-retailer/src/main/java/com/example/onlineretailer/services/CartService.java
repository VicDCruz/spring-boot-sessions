package com.example.onlineretailer.services;

import java.util.Map;

public interface CartService {
    void addToCart(int itemId, int quantity);

    void removeFromCart(int itemId);

    Map<Integer, Integer> getAllItemsInCart();

    double calculateCartCost();
}
