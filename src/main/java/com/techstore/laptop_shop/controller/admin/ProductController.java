package com.techstore.laptop_shop.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.techstore.laptop_shop.domain.Product;
import com.techstore.laptop_shop.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String showProductList(Model model) {
        List<Product> productList = productService.handleGetAllProduct();
        model.addAttribute("productList", productList);
        return "admin/product/index";
    }

    @GetMapping("/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @GetMapping("/{id}")
    public String getDetailProductPage(@PathVariable Long id, Model model) {
        try {
            Product product = productService.handleGetProductDetail(id);
            model.addAttribute("product", product);
            return "admin/product/product-detail";
        } catch (NoSuchElementException e) {
            model.addAttribute("error", e.getMessage());
            return "admin/product/error";
        }
    }

    @GetMapping("/update/{id}")
    public String getEditProductPage(@PathVariable Long id, Model model) {
        try {
            Product product = productService.handleGetProductDetail(id);
            model.addAttribute("product", product);
            return "admin/product/update";
        } catch (NoSuchElementException e) {
            model.addAttribute("error", e.getMessage());
            return "admin/product/error";
        }
    }

    @GetMapping("/delete/{id}")
    public String getDeleteProductPage(@PathVariable Long id, Model model) {
        try {
            Product product = productService.handleGetProductDetail(id);
            model.addAttribute("product", product);
            return "admin/product/delete";
        } catch (NoSuchElementException e) {
            model.addAttribute("error", e.getMessage());
            return "admin/product/error";
        }
    }

    @PostMapping
    public String createNewProduct(
            @ModelAttribute("newProduct") @Valid Product product,
            BindingResult newProductBindingResult,
            @RequestParam("avatarFile") MultipartFile file) {
        try {

            List<FieldError> errors = newProductBindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(">>>" + error.getField() + "--" + error.getDefaultMessage());
            }

            if (newProductBindingResult.hasErrors()) {
                return "admin/product/create";
            }

            productService.handleSaveProduct(product, file);
            return "redirect:/admin/product";
        } catch (IOException e) {
            e.printStackTrace();
            return "admin/user/create";
        }
    }

    @PostMapping("/{id}")
    public String updateProduct(
            @PathVariable Long id,
            @ModelAttribute("product") @Valid Product product,
            @RequestParam("avatarFile") MultipartFile file) {
        try {
            productService.handleUpdateProduct(product, file);
            return "redirect:/admin/product";
        } catch (IOException e) {
            e.printStackTrace();
            return "admin/user/create";
        }
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute Product product) {
        productService.handleDeleteProduct(product.getId());
        return "redirect:/admin/product";
    }
}
