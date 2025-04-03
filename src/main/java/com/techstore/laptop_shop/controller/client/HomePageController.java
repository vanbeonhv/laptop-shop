package com.techstore.laptop_shop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.techstore.laptop_shop.domain.Product;
import com.techstore.laptop_shop.service.ProductService;

@Controller
public class HomePageController {

    private final ProductService productService;

    public HomePageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Product> productList = productService.handleGetAllProduct();
        model.addAttribute("productList", productList);
        return "client/homepage/index";
    }
}
