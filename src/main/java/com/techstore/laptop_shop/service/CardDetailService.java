package com.techstore.laptop_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techstore.laptop_shop.repository.CartDetailRepository;
import com.techstore.laptop_shop.repository.CartRepository;

@Service
public class CardDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserService userService;


    public int getCountCartDetail() {
        Long cartId = cartRepository.findByUser(userService.getUserByEmail("guest@gmail.com")).getId();
        return cartDetailRepository.countByCart(cartRepository.findById(cartId).orElse(null));
    }

}
