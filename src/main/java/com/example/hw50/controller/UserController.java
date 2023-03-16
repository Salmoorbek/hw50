package com.example.hw50.controller;

import com.example.hw50.entity.User;
import com.example.hw50.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/getUserByName/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        return new ResponseEntity<>(userService.getUserByName(name), HttpStatus.OK);
    }
    @GetMapping("/getUserByNickName/{nickName}")
    public ResponseEntity<User> getUserByNickName(@PathVariable String nickName){
        return new ResponseEntity<>(userService.getUserByNickName(nickName), HttpStatus.OK);
    }
    @GetMapping("/registered/{email}")
    public ResponseEntity<String> isRegistered(@PathVariable String email) {
        return new ResponseEntity<>(userService.isRegisteredEmail(email), HttpStatus.OK);
    }
}