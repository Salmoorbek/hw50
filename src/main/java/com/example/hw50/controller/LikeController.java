package com.example.hw50.controller;

import com.example.hw50.dto.LikeDto;
import com.example.hw50.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @GetMapping("/checkPublicationLikes/{publicationId}")
    public ResponseEntity<String> checkPublicationLike(@PathVariable String publicationId) {
        return new ResponseEntity<>(likeService.isUserLikedPublications(Integer.parseInt(publicationId)), HttpStatus.OK);
    }

    //    @GetMapping("/like/{userId}/{publicationId}")
//    public LikeDto likePublicationLike(@PathVariable int userId, @PathVariable int publicationId) {
//        return likeService.likePublication(userId, publicationId);
//    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public LikeDto addPublication(@RequestBody LikeDto likeDto) {
        return likeService.likePublication(likeDto.getUserId(), likeDto.getLikedPublicationId());
    }
}
