package com.example.marketStoreAPI.web.controller;

import com.example.marketStoreAPI.domain.Product;
import com.example.marketStoreAPI.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{id}")
    public Optional<List<Product>> getByCategory(int categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping()
    public Product save(Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public boolean delete(int productId) {
        return productService.delete(productId);
    }
}
