package com.techstore.laptop_shop.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techstore.laptop_shop.domain.Cart;
import com.techstore.laptop_shop.domain.CartDetail;
import com.techstore.laptop_shop.domain.Product;
import com.techstore.laptop_shop.domain.User;
import com.techstore.laptop_shop.repository.CartDetailRepository;
import com.techstore.laptop_shop.repository.CartRepository;
import com.techstore.laptop_shop.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private FileService fileService;
    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartDetailRepository cartDetailRepository;

    public List<Product> handleGetAllProduct() {
        return productRepository.findAll();
    }

    public Product handleSaveProduct(Product product, MultipartFile file) throws IOException {
        String fileName = fileService.handleSaveFile(file, "product");
        product.setImage(fileName);
        return productRepository.save(product);
    }

    public Product handleGetProductDetail(Long id) {
        return productRepository.findById(id).get();
    }

    public void handleUpdateProduct(Product product, MultipartFile file) throws IOException {
        Product existingProduct = productRepository.findById(product.getId()).get();
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDetailDesc(product.getDetailDesc());
        existingProduct.setShortDesc(product.getShortDesc());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setFactory(product.getFactory());
        existingProduct.setTarget(product.getTarget());

        if (file != null && !file.isEmpty()) {
            String fileName = fileService.handleSaveFile(file, "product");
            fileService.handleDeleteFile(product.getImage(), "product");
            existingProduct.setImage(fileName);
        }
        productRepository.save(existingProduct);
    }

    public void handleDeleteProduct(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        fileService.handleDeleteFile(product.getImage(), "product");
    }

    public void handleAddProductToCart(String email, long productId) {

        User user = this.userService.getUserByEmail(email);
        if (user != null) {
            // check user đã có Cart chưa ? nếu chưa -> tạo mới
            Cart cart = this.cartRepository.findByUser(user);

            if (cart == null) {
                // tạo mới cart
                Cart otherCart = new Cart();
                otherCart.setUser(user);
                otherCart.setSum(1);

                cart = this.cartRepository.save(otherCart);
            }

            // save cart_detail
            // tìm product by id

            Optional<Product> productOptional = this.productRepository.findById(productId);
            if (productOptional.isPresent()) {
                Product realProduct = productOptional.get();

                CartDetail cd = new CartDetail();
                cd.setCart(cart);
                cd.setProduct(realProduct);
                cd.setPrice(realProduct.getPrice());
                cd.setQuantity(1);
                this.cartDetailRepository.save(cd);
            }

        }
    }

}
