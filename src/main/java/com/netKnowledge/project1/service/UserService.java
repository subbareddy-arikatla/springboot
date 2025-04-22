package com.netKnowledge.project1.service;

import com.netKnowledge.project1.Model.Journalist;
import com.netKnowledge.project1.Model.User;
import com.netKnowledge.project1.repo.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }
    public List<User> getAllUser(){
       return userRepository.findAll();
    }
    public Optional<User> getUserById(ObjectId myId){
        return userRepository.findById(myId);
    }
    public void deleteById(ObjectId myId){
        userRepository.deleteById(myId);
    }
    public User findByUserName(String UserName){
        return userRepository.findByUserName(UserName);
    }

}
