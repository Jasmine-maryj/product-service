package com.dev.productservice.service;

import com.dev.productservice.dto.ProductRequest;
import com.dev.productservice.entity.Product;
import com.dev.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProductById(Long prodId) throws Exception {
        return productRepository.findById(prodId).orElseThrow(() -> new  Exception("Resource Not found "));
    }

    @Override
    public Product getProductByName(String prodName) {
        Product product = productRepository.findProductByProductName(prodName);
        return product;
    }

    @Override
    public void updateProductInfo(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long prodId) {
        productRepository.deleteById(prodId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
