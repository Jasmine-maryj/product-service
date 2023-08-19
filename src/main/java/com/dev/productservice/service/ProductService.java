package com.dev.productservice.service;

import com.dev.productservice.dto.ProductRequest;
import com.dev.productservice.entity.Product;

public interface ProductService {
    Product createProduct(ProductRequest productRequest);

    Product getProductById(Long prodId) throws Exception;

    Product getProductByName(String prodName);

    void updateProductInfo(ProductRequest productRequest);

    void deleteProduct(Long prodId);
}
