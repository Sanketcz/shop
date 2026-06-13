package com.example.shop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shop.entities.Product;
import com.example.shop.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

     public Product updateProduct(Long id, Product product){
        Product existingProduct = productRepository.findById(id)
                                    .orElseThrow(()->new RuntimeException("Product not found with Id = "+ id));

        existingProduct.setName(product.getName());
        existingProduct.setCatagory(product.getCatagory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setPrice(product.getPrice());
        
        return productRepository.save(existingProduct);
    }

    public List<Product> geProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Product not found with Id = "+ id ));
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


}
