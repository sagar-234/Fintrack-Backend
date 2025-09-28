package com.Fintrack.Fintrack.service;

import com.Fintrack.Fintrack.model.User;
import com.Fintrack.Fintrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl {


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
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found" + id));
    }




}
