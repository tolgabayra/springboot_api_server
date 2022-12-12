package com.bayraktolga.springapiserver.controller;

import com.bayraktolga.springapiserver.model.Product;
import com.bayraktolga.springapiserver.model.User;
import com.bayraktolga.springapiserver.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product body){
        return ResponseEntity.ok(productService.create(body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok("User has been deleted.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Product>> update(@PathVariable Long id, @RequestBody User body){
        return ResponseEntity.ok(productService.update(id, body));
    }
}
