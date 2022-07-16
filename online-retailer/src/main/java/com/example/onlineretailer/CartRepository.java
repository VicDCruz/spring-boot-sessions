package com.example.onlineretailer;

import java.util.HashMap;

public interface CartRepository {
    void add(int itemId, int quantity);

    void remove(int itemId);

    HashMap<Integer, Integer> getAll();
}
