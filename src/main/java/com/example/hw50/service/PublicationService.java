package com.example.hw50.service;

import com.example.hw50.dao.PublicationDao;
import com.example.hw50.dto.PublicationDto;
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

    public PublicationDto addPublication(PublicationDto publicationDto) {
        var publication = Publication.builder()
                .id(publicationDao.getAllPubs().size() + 1)
                .img(publicationDto.getImg())
                .description(publicationDto.getDescription())
                .timeOfPublication(publicationDto.getPublicationTime())
                .build();

        publicationDao.save(publication);
        return PublicationDto.from(publication);
    }
    public boolean deletePublication(Long commentId) {
        //TODO recalculate movie rating before delete
        publicationDao.deleteById(commentId);
        return true;
    }
}
