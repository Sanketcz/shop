package com.example.shop.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shop.dto.OrderItemRequest;
import com.example.shop.dto.OrderRequest;
import com.example.shop.entities.Order;
import com.example.shop.entities.OrderItem;
import com.example.shop.entities.Product;
import com.example.shop.repositories.OrderRepository;
import com.example.shop.repositories.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    
    @Transactional
    public Order createOrder(OrderRequest orderRequest){
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>(); 
        BigDecimal totalPrice = BigDecimal.ZERO;
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRMED");

        for(OrderItemRequest orderItemRequest : orderRequest.getItems()){
            Product product = productRepository.findById(orderItemRequest.getProductId())
            .orElseThrow(()->new RuntimeException("Product not found with Id"+orderItemRequest.getProductId()));
        
            if(product.getStockQuantity()<orderItemRequest.getQuantity()){
                throw new RuntimeException("Not enough stock for "+product.getName());
            }

            BigDecimal priceOfItem = product.getPrice().multiply(BigDecimal.valueOf(orderItemRequest.getQuantity()));
            totalPrice = totalPrice.add(priceOfItem);
            product.setStockQuantity(product.getStockQuantity() - orderItemRequest.getQuantity());
            productRepository.save(product);

            OrderItem orderItem = OrderItem.builder().order(order)
            .product(product)
            .quantity(orderItemRequest.getQuantity())
            .priceAtPurchase(product.getPrice())
            .build();

            orderItems.add(orderItem);
        }
        order.setTotalPrice(totalPrice);
        order.setOrderItem(orderItems);
        return orderRepository.save(order);
    }


    
}
