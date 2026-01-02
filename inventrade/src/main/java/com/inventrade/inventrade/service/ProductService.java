package com.inventrade.inventrade.service;

import com.inventrade.inventrade.entity.Product;
import com.inventrade.inventrade.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService{
    @Autowired
    private ProductRepo productRepo;

    @CacheEvict(value = "products", allEntries = true)
    public void save(Product product) {
        product.setStatus("Y");
        product.setCreatedDate(LocalDateTime.now());
        productRepo.save(product);
    }
    @Cacheable(value = "products")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> findById(long id) {
        return productRepo.findById(id);
    }

    @CacheEvict(value = "products", allEntries = true)
    public void delete(long id) {
         productRepo.deleteById(id);
    }
}
