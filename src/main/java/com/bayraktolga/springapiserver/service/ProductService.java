package com.bayraktolga.springapiserver.service;

import com.bayraktolga.springapiserver.model.Product;
import com.bayraktolga.springapiserver.model.User;
import com.bayraktolga.springapiserver.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public void delete (Long id){
        productRepository.deleteById(id);
    }

    public Optional<Product> update(Long id, User productRequest){
        Optional<Product> product = productRepository.findById(id);
            product.ifPresent(product1 -> {
                product1.setName(productRequest.getName());
                product1.setDescription(productRequest.getDescription());
                product1.setPrice(productRequest.getPrice());
                product1.setStock(product1.getStock());

                productRepository.save(product1);

            });
            return product;

    }

    public Optional<Product> show(Long id){
        return productRepository.findById(id);
    }

    public List<Product> list(){
        List<Product> products = productRepository.findAll();
        return products;
    }

}
