package com.techstore.laptop_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techstore.laptop_shop.domain.Cart;
import com.techstore.laptop_shop.domain.CartDetail;
import com.techstore.laptop_shop.domain.Product;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    CartDetail findByCartAndProduct(Cart cart, Product product);
    int countByCart(Cart cart);
}
