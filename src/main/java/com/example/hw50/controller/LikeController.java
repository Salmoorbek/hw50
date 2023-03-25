package com.example.hw50.controller;

import com.example.hw50.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;
    @GetMapping("/checkPublicationLikes/{publicationId}")
    public ResponseEntity<String> checkPublicationLike(@PathVariable String publicationId) {
        return new ResponseEntity<>(likeService.isUserLikedPublications(Integer.parseInt(publicationId)), HttpStatus.OK);
    }
}
