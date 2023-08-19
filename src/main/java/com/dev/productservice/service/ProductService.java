package com.dev.productservice.service;

import com.dev.productservice.dto.ProductRequest;
import com.dev.productservice.dto.ProductResponse;
import com.dev.productservice.entity.Product;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long prodId) throws Exception;

    ProductResponse getProductByName(String prodName);

    void updateProductInfo(ProductRequest productRequest);

    void deleteProduct(Long prodId);

    List<ProductResponse> getAllProducts();
}
