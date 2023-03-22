package com.example.hw50.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Data
@Builder
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
