package com.Fintrack.Fintrack.controller;


import com.Fintrack.Fintrack.model.User;
import com.Fintrack.Fintrack.service.UserService;
import com.Fintrack.Fintrack.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceimpl;

    @GetMapping
    public List<User> getAllUser(){
        return userServiceimpl.getAllUsers();
    }

    @PostMapping
    public  User createUser(@RequestBody User user){
        return userServiceimpl.createUser(user);
    }

    @GetMapping("/{id}")
   public User getUserById(@PathVariable Long id){
        return userServiceimpl.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return userServiceimpl.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userServiceimpl.deleteUser(id);
        return "User with ID" + id + "  " + "has been deleted";
    }


}
