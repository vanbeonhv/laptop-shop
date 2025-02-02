package com.techstore.laptop_shop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String getHomePage() {
        return "client/homepage/index";
    }

    @GetMapping("/home")
    public String getHomePage2() {
        return "client/homepage/index";
    }

}
