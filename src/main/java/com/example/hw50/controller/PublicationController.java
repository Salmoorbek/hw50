package com.example.hw50.controller;

import com.example.hw50.entity.Publication;
import com.example.hw50.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PublicationController {
    private final PublicationService publicationsService;

    @GetMapping("/takePublicationForUser/{userId}")
    public ResponseEntity<List<Publication>>  takePublicationsForUser(@PathVariable String userId){
        return new ResponseEntity<>(publicationsService.getPublicationForUser(Integer.parseInt(userId)), HttpStatus.OK);
    }
    @GetMapping("/takePublicationsForUserBySubscriptions/{userId}")
    public ResponseEntity<List<Publication>> takePublicationsForUserBySubscriptions(@PathVariable String userId){
        return new ResponseEntity<>(publicationsService.getPublicationsForUserBySubscriptions(Integer.parseInt(userId)), HttpStatus.OK);
    }
}
