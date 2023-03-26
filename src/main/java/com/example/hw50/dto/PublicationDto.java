package com.example.hw50.dto;

import com.example.hw50.entity.Publication;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class PublicationDto {
    private int id;
    private String img;
    private String description;
    private LocalDateTime publicationTime;

    public static PublicationDto from(Publication publication){
        return builder()
                .id(publication.getId())
                .img(publication.getImg())
                .description(publication.getDescription())
                .publicationTime(publication.getTimeOfPublication())
                .build();
    }
}
