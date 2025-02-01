package com.techstore.laptop_shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @GetMapping("")
    public String getProductPage() {
        return "admin/product/index";
    }
}
