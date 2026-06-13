package com.example.shop.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemRequest {
    
    @NotNull(message = "Product Id is required.")
    private Long productId;
    @NotNull(message = "Quantity is required.")
    @Min(value = 1,message = "Quantity must greate than equal to 1")
    private Integer quantity;


}
