package com.example.onlineretailer.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HashCartRepositoryTest {
    private final CartRepository repositoryFixture = new HashCartRepository();

    @Test
    void cart_emptyInitially() {
        assertTrue(this.repositoryFixture.getAll().isEmpty());
    }

    @Test
    void addItems_itemsAdded() {
        this.repositoryFixture.add(1, 10);
        this.repositoryFixture.add(2, 10);
        this.repositoryFixture.add(3, 10);

        Map<Integer, Integer> cart = this.repositoryFixture.getAll();
        assertEquals(cart.size(), 3);
        assertEquals(cart.get(1), 10);
        assertEquals(cart.get(2), 10);
        assertEquals(cart.get(3), 10);
    }

    @Test
    void addSameItem_countIncremented() {
        this.repositoryFixture.add(1, 10);
        this.repositoryFixture.add(1, 10);
        this.repositoryFixture.add(1, 10);

        assertEquals(this.repositoryFixture.getAll().get(1), 30);
    }

    @Test
    void removeItem_itemRemoved() {
        this.repositoryFixture.add(1, 10);
        this.repositoryFixture.add(2, 10);
        this.repositoryFixture.remove(1);

        assertNull(this.repositoryFixture.getAll().get(1));
        assertEquals(this.repositoryFixture.getAll().get(2), 10);
    }
}