package com.techstore.laptop_shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techstore.laptop_shop.domain.Product;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @GetMapping("")
    public String getProductPage() {
        return "admin/product/index";
    }

    @GetMapping("/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }
}
