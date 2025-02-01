package com.techstore.laptop_shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techstore.laptop_shop.domain.User;
import com.techstore.laptop_shop.repository.UserRepository;

@Service
public class UserService {
    final private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "hello from service";
    }

    public User handleSaveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> handleGetAllUser() {
        return userRepository.findAll();
    }

    public User handleGetUserDetail(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    public void handleUpdateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setAddress(updatedUser.getAddress());
        existingUser.setPhone(updatedUser.getPhone());
        userRepository.save(existingUser);
    }

    public void handleDeleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
