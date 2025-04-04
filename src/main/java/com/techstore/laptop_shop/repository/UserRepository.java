package com.techstore.laptop_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techstore.laptop_shop.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
