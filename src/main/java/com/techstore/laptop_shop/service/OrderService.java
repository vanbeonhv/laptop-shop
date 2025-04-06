package com.techstore.laptop_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techstore.laptop_shop.domain.Cart;
import com.techstore.laptop_shop.domain.CartDetail;
import com.techstore.laptop_shop.domain.Order;
import com.techstore.laptop_shop.domain.OrderProduct;
import com.techstore.laptop_shop.domain.User;
import com.techstore.laptop_shop.repository.CartDetailRepository;
import com.techstore.laptop_shop.repository.CartRepository;
import com.techstore.laptop_shop.repository.OrderProductRepository;
import com.techstore.laptop_shop.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private UserService userService;

    public void handlePlaceOrder(
            String receiverName, String receiverAddress, String receiverPhone) {

        User user = userService.getUserByEmail("guest@gmail.com");

        // create order
        Order order = new Order();
        order.setUser(user);
        order.setReceiverName(receiverName);
        order.setReceiverAddress(receiverAddress);
        order.setReceiverPhone(receiverPhone);
        order.setStatus("PENDING");
        order = this.orderRepository.save(order);

        // create orderDetail/orderProduct

        // step 1: get cart by user
        Cart cart = this.cartRepository.findByUser(user);
        if (cart != null) {
            List<CartDetail> cartDetails = cart.getCartDetails();

            if (cartDetails != null) {
                for (CartDetail cd : cartDetails) {
                    OrderProduct orderProduct = new OrderProduct();

                    orderProduct.setOrder(order);
                    orderProduct.setProduct(cd.getProduct());
                    orderProduct.setPrice(cd.getPrice());
                    orderProduct.setQuantity(cd.getQuantity());

                    this.orderProductRepository.save(orderProduct);
                }

                // step 2: delete cart_detail and cart
                for (CartDetail cd : cartDetails) {
                    this.cartDetailRepository.deleteById(cd.getId());
                }

                this.cartRepository.deleteById(cart.getId());
            }
        }

    }

}
