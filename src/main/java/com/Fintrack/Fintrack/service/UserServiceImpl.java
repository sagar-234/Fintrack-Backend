package com.Fintrack.Fintrack.service;

import com.Fintrack.Fintrack.model.User;
import com.Fintrack.Fintrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{


@Autowired
private UserRepository userRepository;


public User createUser(User user){
    return userRepository.save(user);

}


public User getUserById(Long id){
return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found" + id));
  }
public List<User> getAllUsers(){
    return  userRepository.findAll();
}


public User updateUser(Long id,User user){
    User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found" + id));

    existingUser.setUsername(user.getUsername());
    existingUser.setEmail(user.getEmail());
    existingUser.setPassword(user.getPassword());
    existingUser.setRole(user.getRole());

    return userRepository.save(existingUser);
    }


public void deleteUser(Long id){
    if (!userRepository.existsById(id)){
        throw new RuntimeException("User does not exists" + id);
    }
    userRepository.deleteById(id);
    }
}
