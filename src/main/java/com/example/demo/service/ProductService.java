package com.example.demo.service;

import com.example.demo.product.data.entity.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long pId);
    List<Product> findAll();
    String addProduct(Product product);
    List<Product> findByPriceBelow(double price);
    String deleteProduct(Long pId);
    String updateProduct(Product product);
}

