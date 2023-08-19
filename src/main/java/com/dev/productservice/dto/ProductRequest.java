package com.dev.productservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long productId;
    private String productName;
    private Double price;
    private int quantity;
}
