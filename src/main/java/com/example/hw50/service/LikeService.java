package com.example.hw50.service;

import com.example.hw50.dao.LikeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeDao likeDao;
    public String isUserLikedPublications(int likedPublicationId){
        return likeDao.userLikedPublication(likedPublicationId);
    }
}
