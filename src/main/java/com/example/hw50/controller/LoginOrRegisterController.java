package com.example.hw50.controller;

import com.example.hw50.dto.UserDto;
import com.example.hw50.entity.User;
import com.example.hw50.service.LoginOrRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LoginOrRegisterController {
    private final LoginOrRegisterService loginOrRegisterService;
    @GetMapping("/login/{accName}/{password}")
    public ResponseEntity<String> isLogin(@PathVariable String accName, @PathVariable String password) {
        return new ResponseEntity<>(loginOrRegisterService.author(accName,password), HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto addComment(@RequestBody User user){
        return loginOrRegisterService.register(user);
    }
}
