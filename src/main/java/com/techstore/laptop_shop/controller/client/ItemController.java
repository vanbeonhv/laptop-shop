package com.techstore.laptop_shop.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techstore.laptop_shop.domain.Cart;
import com.techstore.laptop_shop.domain.CartDetail;
import com.techstore.laptop_shop.domain.Product;
import com.techstore.laptop_shop.service.CartDetailService;
import com.techstore.laptop_shop.service.CartService;
import com.techstore.laptop_shop.service.OrderService;
import com.techstore.laptop_shop.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ItemController {

    private final OrderService orderService;
    private final ProductService productService;
    private final CartDetailService cardDetailService;
    private final CartService cartService;

    public ItemController(ProductService productService, CartDetailService cardDetailService, CartService cartService,
            OrderService orderService) {
        this.productService = productService;
        this.cardDetailService = cardDetailService;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @GetMapping("/product/{id}")
    public String getProductPage(Model model, @PathVariable Long id) {
        Product pr = this.productService.handleGetProductDetail(id);
        model.addAttribute("product", pr);
        model.addAttribute("id", id);
        return "client/product/detail";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String addProductToCart(@PathVariable long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        long productId = id;
        // String email = (String) session.getAttribute("email");
        String email = "guest@gmail.com";

        this.productService.handleAddProductToCart(email, productId);

        return "redirect:/";
    }

    @GetMapping("/cart")
    public String getCartPage(Model model, HttpServletRequest request) {
        Cart cart = cartService.getCart();
        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();

        double totalPrice = 0;
        for (CartDetail cd : cartDetails) {
            totalPrice += cd.getPrice() * cd.getQuantity();
        }

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);

        model.addAttribute("cart", cart);

        return "client/cart/index";
    }

    @PostMapping("/delete-cart-product/{id}")
    public String deleteCartDetail(@PathVariable long id, HttpServletRequest request) {
        long cartDetailId = id;
        this.cardDetailService.handleRemoveCartDetail(cartDetailId);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String getCheckOutPage(Model model, HttpServletRequest request) {

        Cart cart = this.cartService.getCart();

        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();

        double totalPrice = 0;
        for (CartDetail cd : cartDetails) {
            totalPrice += cd.getPrice() * cd.getQuantity();
        }

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);

        return "client/cart/checkout";
    }

    @PostMapping("/confirm-checkout")
    public String getCheckOutPage(@ModelAttribute("cart") Cart cart) {
        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();
        this.cardDetailService.handleUpdateCartBeforeCheckout(cartDetails);
        return "redirect:/checkout";
    }

    @PostMapping("/place-order")
    public String handlePlaceOrder(
            HttpServletRequest request,
            @RequestParam("receiverName") String receiverName,
            @RequestParam("receiverAddress") String receiverAddress,
            @RequestParam("receiverPhone") String receiverPhone) {

        this.orderService.handlePlaceOrder(receiverName, receiverAddress, receiverPhone);

        return "redirect:/thanks";
    }

    @GetMapping("/thanks")
    public String getThankYouPage(Model model) {

        return "client/cart/thanks";
    }
}
