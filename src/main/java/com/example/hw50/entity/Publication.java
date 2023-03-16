package com.example.hw50.entity;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
public class Publication {
    private int id;
    private String img;
    private String description;
    private LocalDateTime timeOfPublication;
    private int userID;

    public Publication(int id, String img, String description, LocalDateTime timeOfPublication, int userID) {
        this.id = id;
        this.img = img;
        this.description = description;
        this.timeOfPublication = timeOfPublication;
        this.userID = userID;
    }
}
