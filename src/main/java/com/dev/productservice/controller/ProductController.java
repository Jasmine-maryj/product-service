package com.dev.productservice.controller;

import com.dev.productservice.dto.ProductRequest;
import com.dev.productservice.dto.ProductResponse;
import com.dev.productservice.entity.Product;
import com.dev.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@RequestParam("id") Long prodId) throws Exception {
        ProductResponse product = productService.getProductById(prodId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductResponse> getProductByName(@RequestParam("name") String prodName){
        ProductResponse product = productService.getProductByName(prodName);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
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
