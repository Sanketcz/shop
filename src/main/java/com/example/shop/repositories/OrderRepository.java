package com.example.shop.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{    
}