package com.example.onlineretailer.services;

import com.example.onlineretailer.repositories.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
class MapCartServiceTest {
    @MockBean
    private CartRepository mockRepo;

    @Autowired
    private MapCartService serviceFixture;

    @Test
    void addItemToCart_itemAdded() {
        this.serviceFixture.addToCart(1, 10);
        verify(mockRepo).add(eq(1), eq(10));
    }

    @Test
    void addUnknownItemToCart_noAction() {
        this.serviceFixture.addToCart(-1, 10);
        verify(mockRepo, times(0)).add(anyInt(), anyInt());
    }

    @Test
    void removeItemFromCart_itemRemoved() {
        this.serviceFixture.removeFromCart(1);
        verify(mockRepo).remove(eq(1));
    }

    @Test
    void removeUnknownItemFromCart_noAction() {
        this.serviceFixture.removeFromCart(1234);
        verify(mockRepo, times(0)).remove(anyInt());
    }

    @Test
    void calculateCartCost_correctCostReturned() {
        Map<Integer, Integer> cart = new HashMap<>();
        cart.put(2, 1);
        cart.put(3, 2);
        cart.put(4, 5);
        when(mockRepo.getAll()).thenReturn(cart);

        assertEquals(280, this.serviceFixture.calculateCartCost());
    }
}