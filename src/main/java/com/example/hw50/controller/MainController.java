package com.example.hw50.controller;

import com.example.hw50.service.TestClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final TestClassService testClassService;

    @GetMapping("/create")
    public ResponseEntity<String> createTables(){
        return new ResponseEntity<>(testClassService.createTables(), HttpStatus.OK);
    }
}
