package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.DAO.ProductDAO;
import com.java.entity.Products;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    public List<Products> getAllProducts() {
        return productDAO.findAll();
    }

    public Products getProductById(int id) {
        return productDAO.findById(id).orElse(null);
    }

    public void saveProduct(Products product) {
        productDAO.save(product);
    }

    public void updateProduct(Products product) {
        productDAO.save(product);
    }

    public void deleteProduct(int id) {
        productDAO.deleteById(id);
    }
}
