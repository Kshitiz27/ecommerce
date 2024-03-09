package com.ecom.service;

import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProducts(){
        return this.productRepo.findAll();
    }

    public Optional<Product> getProductById(Long productId){
        return this.productRepo.findById(productId);
    }

//    public Optional<Product> getProductByName(String productName){
//        return this.productRepo.findByNameIgnoreCase(productName);
//    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Long productId, Product updatedProduct){
        Optional<Product> existingProduct = productRepo.findById(productId);
        if (existingProduct.isPresent()){
            Product updateProduct = existingProduct.get();
            updateProduct.setProductName(updatedProduct.getProductName());
            updateProduct.setProductPrice(updatedProduct.getProductPrice());
            updateProduct.setProductDesc(updatedProduct.getProductDesc());
        }
        return null;
    }

    public void deleteProduct(Long productId){
        productRepo.deleteById(productId);
    }
}
