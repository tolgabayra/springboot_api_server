package com.bayraktolga.springapiserver.service;

import com.bayraktolga.springapiserver.model.Product;
import com.bayraktolga.springapiserver.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product create(Product productRequest){
        Product product = new Product();
        product.setId(product.getId());
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setImages(productRequest.getImages());

        return productRepository.save(product);

    }
}
