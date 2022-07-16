package com.example.onlineretailer;

import lombok.Getter;
import lombok.Setter;

public class Item {
    private final int id;
    @Getter @Setter private String description;
    @Getter @Setter private double price;

    public Item(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("[%02d], %s, £%.2f", id, description, price);
    }
}
