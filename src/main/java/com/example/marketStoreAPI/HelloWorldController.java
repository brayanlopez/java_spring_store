package com.example.marketStoreAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.marketStoreAPI.persistence.ProductRepository;

@RestController
@RequestMapping("/saludar")
public class HelloWorldController {

    @GetMapping("/hola")
    public String Saludar() {
        ProductRepository productRepository = new ProductRepository();
        System.out.println(productRepository.getAll().toString());
        return "<h1>hola mundo</h1>";
    }

    @GetMapping("/products")
    public String GetProducts() {
        return new ProductRepository().getAll().toString();
    }
}
