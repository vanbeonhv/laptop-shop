package com.techstore.laptop_shop.controller.client;

import java.util.List;

import javax.smartcardio.Card;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.techstore.laptop_shop.domain.Product;
import com.techstore.laptop_shop.service.CardDetailService;
import com.techstore.laptop_shop.service.ProductService;

@Controller
public class HomePageController {

    private final ProductService productService;
    private final CardDetailService cardDetailService;

    public HomePageController(ProductService productService, CardDetailService cardDetailService) {
        this.productService = productService;
        this.cardDetailService = cardDetailService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Product> productList = productService.handleGetAllProduct();
        int cartCount = cardDetailService.getCountCartDetail();

        model.addAttribute("productList", productList);
        model.addAttribute("cartCount", cartCount);
        return "client/homepage/index";
    }
}
