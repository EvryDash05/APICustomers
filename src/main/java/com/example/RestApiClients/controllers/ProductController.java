package com.example.RestApiClients.controllers;

import com.example.RestApiClients.models.Product;
import com.example.RestApiClients.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService prodcutService;

    @GetMapping("/listProducts")
    public List<Product> getListProducts(){
        return prodcutService.getListProducts();
    }

}
