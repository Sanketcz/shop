package com.example.shop.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.shop.entities.Product;
import com.example.shop.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService prodcuctService;

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return prodcuctService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@Valid @RequestBody Product product){
        return prodcuctService.updateProduct(id, product);
    }

    @GetMapping
    public List<Product> geProducts(){
        return prodcuctService.geProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return prodcuctService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){   
        prodcuctService.deleteProduct(id);
    }

}
