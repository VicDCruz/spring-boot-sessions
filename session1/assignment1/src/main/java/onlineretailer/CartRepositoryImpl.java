package onlineretailer;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartRepositoryImpl implements CartRepository {
    private HashMap<Integer, Integer> items;

    public CartRepositoryImpl() {
        this.items = new HashMap<>();
    }

    private boolean isItemExist(int itemId) {
        return this.items.containsKey(itemId);
    }

    @Override
    public void add(int itemId, int quantity) {
        if (!this.isItemExist(itemId)) {
            this.items.put(itemId, quantity);
        } else {
            int newQuantity = this.items.get(itemId) + quantity;
            this.items.replace(itemId, newQuantity);
        }
    }

    @Override
    public void remove(int itemId) {
        if (this.isItemExist(itemId)) {
            this.items.remove(itemId);
        }
    }

    @Override
    public Map<Integer, Integer> getAll() {
        return this.items;
    }
}
