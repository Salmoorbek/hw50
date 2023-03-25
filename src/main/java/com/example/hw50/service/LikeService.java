package com.example.hw50.service;

import com.example.hw50.dao.LikeDao;
import com.example.hw50.dto.LikeDto;
import com.example.hw50.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeDao likeDao;

    public String isUserLikedPublications(int likedPublicationId) {
        return likeDao.userLikedPublication(likedPublicationId);
    }

    public LikeDto likePublication(int userId, int publicationId) {
        var like = Like.builder()
                .id(likeDao.getAllLikes().size() + 1)
                .userId(userId)
                .likedPublicationId(publicationId)
                .lickedTime(LocalDateTime.now())
                .build();

        likeDao.save(like);
        return LikeDto.from(like);
    }
}
