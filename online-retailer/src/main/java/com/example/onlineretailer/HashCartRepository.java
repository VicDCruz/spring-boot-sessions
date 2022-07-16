package com.example.onlineretailer;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@ToString
@Repository
@AllArgsConstructor
public class HashCartRepository implements CartRepository {
    private HashMap<Integer, Integer> cart;

    @Override
    public void add(int itemId, int quantity) {
        if (this.cart.containsKey(itemId)) this.cart.replace(itemId, this.cart.get(itemId) + quantity);
        else this.cart.put(itemId, quantity);
    }

    @Override
    public void remove(int itemId) {
        this.cart.remove(itemId);
    }

    @Override
    public HashMap<Integer, Integer> getAll() {
        return this.cart;
    }
}
