package com.dev.productservice.controller;

import com.dev.productservice.dto.ProductRequest;
import com.dev.productservice.entity.Product;
import com.dev.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest){
        Product product = productService.createProduct(productRequest);
        return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@RequestParam("id") Long prodId) throws Exception {
        Product product = productService.getProductById(prodId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@RequestParam("name") String prodName){
        Product product = productService.getProductByName(prodName);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProductInfo(@RequestBody ProductRequest productRequest){
        productService.updateProductInfo(productRequest);
        return ResponseEntity.ok("Update successful!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long prodId){
        productService.deleteProduct(prodId);
        return ResponseEntity.ok("Deleted Successfully!");
    }
}
