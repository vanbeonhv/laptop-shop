package com.techstore.laptop_shop.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techstore.laptop_shop.domain.User;
import com.techstore.laptop_shop.repository.RoleRepository;
import com.techstore.laptop_shop.repository.UserRepository;

@Service
public class UserService {
    final private UserRepository userRepository;
    final private FileService fileService;
    final private RoleRepository roleRepository;
    final private PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            FileService fileService,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.fileService = fileService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String handleHello() {
        return "hello from service";
    }

    public User handleSaveUser(User user, MultipartFile file) throws IOException {
        String fileName = fileService.handleSaveFile(file, "avatar");
        user.setAvatar(fileName);
        user.setRole(roleRepository.findByName(user.getRole().getName()));
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

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

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
