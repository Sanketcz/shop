package com.example.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{
}