package com.example.shop.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.dto.OrderRequest;
import com.example.shop.entities.Order;
import com.example.shop.services.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService orderService;

    @PostMapping
    public Order creatOrder(@Valid @RequestBody OrderRequest orderRequest){
       return orderService.createOrder(orderRequest);
    }

    //Get All Order
    //Get Order By Id
    

}
