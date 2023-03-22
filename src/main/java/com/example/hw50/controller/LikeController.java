package com.example.hw50.controller;

import com.example.hw50.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;
    @GetMapping("/checkPublicationLikes/{publicationId}")
    public ResponseEntity<String> checkPublicationLike(@PathVariable String publicationId) {
        return new ResponseEntity<>(likeService.isUserLikedPublications(Integer.parseInt(publicationId)), HttpStatus.OK);
    }
}
