package com.techstore.laptop_shop.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techstore.laptop_shop.domain.Product;
import com.techstore.laptop_shop.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private FileService fileService;

    @Autowired
    private ProductRepository productRepository;

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
}
