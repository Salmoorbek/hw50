package com.example.hw50.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Data
public class Like {
    private int id;
    private int likedPublicationId;
    private LocalDateTime lickedTime;
    private int userId;

    public Like(int id, int likedPublication, LocalDateTime lickedTime, int userID) {
        this.id = id;
        this.likedPublicationId = likedPublication;
        this.lickedTime = lickedTime;
        this.userId = userID;
    }
}
