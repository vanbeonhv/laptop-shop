package com.techstore.laptop_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techstore.laptop_shop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
