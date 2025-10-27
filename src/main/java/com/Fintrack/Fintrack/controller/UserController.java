package com.Fintrack.Fintrack.controller;


import com.Fintrack.Fintrack.model.User;
import com.Fintrack.Fintrack.repository.UserRepository;
import com.Fintrack.Fintrack.service.UserService;
import com.Fintrack.Fintrack.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping
    public  User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
   public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return userService.updateUser(id, user);
    }
//    @GetMapping("/email/{email}")
//    public Optional<User> getByEmail(@PathVariable String email){
//        return userService.findByEmail(email);
//
//    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User with ID" + id + "  " + "has been deleted";
    }




}
