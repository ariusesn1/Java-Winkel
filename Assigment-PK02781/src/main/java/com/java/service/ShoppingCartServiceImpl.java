package com.java.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.entity.CartItem;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private Map<Integer, CartItem> cartItems;
    
    public ShoppingCartServiceImpl() {
        cartItems = new HashMap<>();
    }
    
    @Override
    public void add(Integer id, CartItem entity) {
        cartItems.put(id, entity);
    }
    
    @Override
    public void remove(Integer id) {
        cartItems.remove(id);
    }
    
    @Override
    public void update(Integer id, int qty) {
        CartItem cartItem = cartItems.get(id);
        if (cartItem != null) {
            cartItem.setQuantity(qty);
        }
    }
    
    @Override
    public void clear() {
        cartItems.clear();
    }
    
    @Override
    public int getCount() {
        return cartItems.size();
    }
    
    @Override
    public Collection<CartItem> getCartItems() {
        return cartItems.values();
    }
}
