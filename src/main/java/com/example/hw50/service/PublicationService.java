package com.example.hw50.service;

import com.example.hw50.dao.PublicationDao;
import com.example.hw50.entity.Publication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationService {
    private final PublicationDao publicationDao;

    public List<Publication> getPublicationForUser(int userId){
        return publicationDao.getPublicationsForUser(userId);
    }

    public List<Publication> getPublicationsForUserBySubscriptions(int userId) {
        return publicationDao.getPublicationsForUserBySubscriptions(userId);
    }
}
