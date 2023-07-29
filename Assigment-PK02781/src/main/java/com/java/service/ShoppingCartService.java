package com.java.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.java.entity.CartItem;

public interface ShoppingCartService {
	void add(Integer id, CartItem entity);
	void remove(Integer id);
	void update(Integer id, int qty);
	void clear();
	Collection<CartItem> getCartItems();
	int getCount();
}
