package com.dev.productservice.service;

import com.dev.productservice.dto.ProductRequest;
import com.dev.productservice.dto.ProductResponse;
import com.dev.productservice.entity.Product;
import com.dev.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        productRepository.save(product);
    }

    @Override
    public ProductResponse getProductById(Long prodId) throws Exception {
        Product product = productRepository.findById(prodId).orElseThrow(() -> new  Exception("Resource Not found "));
        return ProductResponse.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public ProductResponse getProductByName(String prodName) {
        Product product = productRepository.findProductByProductName(prodName);
        return ProductResponse.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
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
    public List<ProductResponse> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return getAllProducts(productList);
    }

    private List<ProductResponse> getAllProducts(List<Product> productList){
        return productList.stream()
                .map(product -> new ProductResponse(product.getProductName(), product.getPrice(), product.getQuantity()))
                .collect(Collectors.toList());
    }
}
