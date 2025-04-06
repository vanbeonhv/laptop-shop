package com.techstore.laptop_shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techstore.laptop_shop.domain.Cart;
import com.techstore.laptop_shop.domain.CartDetail;
import com.techstore.laptop_shop.repository.CartDetailRepository;
import com.techstore.laptop_shop.repository.CartRepository;

@Service
public class CartDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserService userService;

    public int getCountCartDetail() {
        Cart cart = cartRepository.findByUser(userService.getUserByEmail("guest@gmail.com"));
        if (cart == null) {
            return 0;
        }
        Long cartId = cart.getId();

        return cartDetailRepository.countByCart(cartRepository.findById(cartId).orElse(null));
    }

    public void handleRemoveCartDetail(long cartDetailId) {
        Optional<CartDetail> cartDetailOptional = this.cartDetailRepository.findById(cartDetailId);
        if (cartDetailOptional.isPresent()) {
            CartDetail cartDetail = cartDetailOptional.get();

            Cart currentCart = cartDetail.getCart();
            // delete cart-detail
            this.cartDetailRepository.deleteById(cartDetailId);

            // update cart
            if (currentCart.getSum() > 1) {
                // update current cart
                int s = currentCart.getSum() - 1;
                currentCart.setSum(s);
                this.cartRepository.save(currentCart);
            }
        }
    }

    public void handleUpdateCartBeforeCheckout(List<CartDetail> cartDetails) {
        for (CartDetail cartDetail : cartDetails) {
            Optional<CartDetail> cdOptional = this.cartDetailRepository.findById(cartDetail.getId());
            if (cdOptional.isPresent()) {
                CartDetail currentCartDetail = cdOptional.get();
                currentCartDetail.setQuantity(cartDetail.getQuantity());
                this.cartDetailRepository.save(currentCartDetail);
            }
        }
    }

}
