package com.dev.productservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private Long productId;
    private String productName;
    private Double price;
    private int quantity;
}
