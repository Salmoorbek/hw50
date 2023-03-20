package com.example.hw50.controller;

import com.example.hw50.dto.UserDto;
import com.example.hw50.entity.User;
import com.example.hw50.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
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
    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<String> isLogin(@PathVariable String email,@PathVariable String password) {
        return new ResponseEntity<>(userService.author(email,password), HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto addComment(@RequestBody User user){
        return userService.register(user);
    }
}
