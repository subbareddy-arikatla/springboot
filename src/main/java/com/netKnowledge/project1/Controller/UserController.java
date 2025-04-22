package com.netKnowledge.project1.Controller;

import com.netKnowledge.project1.Model.Journalist;
import com.netKnowledge.project1.Model.User;
import com.netKnowledge.project1.service.ServiceEntity;
import com.netKnowledge.project1.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController

{
    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userName){
        User userindb=userService.findByUserName(userName );
        if(userindb != null){
            userindb.setUserName(user.getUserName());
            userindb.setPassword(user.getPassword());
            userService.saveUser(userindb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
