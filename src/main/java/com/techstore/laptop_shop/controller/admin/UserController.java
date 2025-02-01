package com.techstore.laptop_shop.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.techstore.laptop_shop.domain.User;
import com.techstore.laptop_shop.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showUserList(Model model) {
        List<User> userList = userService.handleGetAllUser();
        model.addAttribute("userList", userList);
        return "admin/user/index";
    }

    @GetMapping("/create")
    public String getNewUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @GetMapping("/{id}")
    public String getDetailUserPage(@PathVariable Long id, Model model) {
        try {
            User user = userService.handleGetUserDetail(id);
            model.addAttribute("user", user);
            return "admin/user/user-detail";
        } catch (NoSuchElementException e) {
            model.addAttribute("error", e.getMessage());
            return "admin/user/error";
        }
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("newUser") User user, @RequestParam("avatarFile") MultipartFile file) {
        try {
            userService.handleSaveUser(user, file);
            return "redirect:/admin/user";
        } catch (IOException e) {
            // return error message
            e.printStackTrace();
            return "admin/user/create";
        }
    }

    @GetMapping("/update/{id}")
    public String getEditUserPage(@PathVariable Long id, Model model) {
        try {
            User user = userService.handleGetUserDetail(id);
            model.addAttribute("user", user);
            return "admin/user/update";
        } catch (NoSuchElementException e) {
            model.addAttribute("error", e.getMessage());
            return "admin/user/error";
        }
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
        try {
            userService.handleUpdateUser(id, user);
            return "redirect:/admin/user";
        } catch (NoSuchElementException e) {
            return "admin/user/error";
        }
    }

    @GetMapping("/delete/{id}")
    public String getDeleteUserPage(@PathVariable long id, Model model) {
        User user = new User();
        user.setId(id);
        model.addAttribute("user", user);
        return "admin/user/delete";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute User user) {
        userService.handleDeleteUser(user.getId());
        return "redirect:/admin/user";
    }
}