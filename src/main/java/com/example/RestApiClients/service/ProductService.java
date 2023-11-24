package com.example.RestApiClients.service;

import com.example.RestApiClients.models.Product;
import com.example.RestApiClients.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getListProducts() {
        return productRepository.findAll();
    }

    public Optional<?> getProductById(String id) {
        return productRepository.findById(id);
    }



}
