package com.ecom.service;

import com.ecom.model.Product;
import com.ecom.model.User;
import com.ecom.repository.ProductRepository;
import com.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getAllUsers(){
        return this.userRepo.findAll();
    }

    public Optional<User> getUserById(Long userId){
        return this.userRepo.findById(userId);
    }

//    public Optional<Product> getProductByName(String productName){
//        return this.productRepo.findByNameIgnoreCase(productName);
//    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(Long userId, User updatedUser){
        Optional<User> existingUser = userRepo.findById(userId);
        if (existingUser.isPresent()){
            User updateUser = existingUser.get();
//            updateUser.(updatedProduct.getProductName());
//            updateUser.setProductPrice(updatedProduct.getProductPrice());
//            updateUser.setUs
        }
        return null;
    }

    public void deleteUser(Long userId){
        userRepo.deleteById(userId);
    }
}
