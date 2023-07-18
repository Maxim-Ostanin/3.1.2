package com.ostanin.project31.Boot.controller;


import com.ostanin.project31.Boot.models.User;
import com.ostanin.project31.Boot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


    private final UserService userServiceImpl;

    @Autowired
    public HelloController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();

        messages.add("Hello!");
        messages.add("To show all users press:");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/users")
    public String showAllUsers(ModelMap model) {
        List<User> userList = userServiceImpl.getAllUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/users/{id}")
    public String showUser(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userServiceImpl.getUserById(id));
        return "showUser";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userServiceImpl.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("users")
    public String create(@ModelAttribute("user") User user) {
        userServiceImpl.addUser(user.getName(), user.getLastName(), user.getAge());
        return "redirect:/users";
    }

    @GetMapping("users/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServiceImpl.getUserById(id));
        return "edit";
    }

    @PatchMapping("users/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userServiceImpl.updateUser(id, user.getName(), user.getLastName(), user.getAge());
        return "redirect:/users";
    }

}