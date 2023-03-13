package com.example.hw50.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Publication {
    private int id;
    private String img;
    private String description;
    private LocalDateTime timeOfPublication;

    public Publication(int id, String img, String description, LocalDateTime timeOfPublication) {
        this.id = id;
        this.img = img;
        this.description = description;
        this.timeOfPublication = timeOfPublication;
    }
}
