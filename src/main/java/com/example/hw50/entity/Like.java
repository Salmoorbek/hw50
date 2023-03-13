package com.example.hw50.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Like {
    private int id;
    private User likedUser;
    private Publication likedPublication;
    private LocalDateTime lickedTime;

    public Like(int id, User likedUser, Publication likedPublication, LocalDateTime lickedTime) {
        this.id = id;
        this.likedUser = likedUser;
        this.likedPublication = likedPublication;
        this.lickedTime = lickedTime;
    }
}
