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

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public void updateStock(String prodcutId, int quantity){

        Product product = getProductById(prodcutId).get();
        int updateStock;

        if(product != null){
            int currentStock = product.getQuantity();
            updateStock = currentStock - quantity;
            if(updateStock < quantity){
                updateStock = 0;
            }
            product.setQuantity(updateStock);
            productRepository.save(product);
        }

    }

}
