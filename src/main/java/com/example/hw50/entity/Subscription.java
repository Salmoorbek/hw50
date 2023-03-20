package com.example.hw50.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
public class Subscription {
    private int id;
    private int subscribes;
    private int subscribedTo;
    private LocalDateTime subscribeTime;

    public Subscription(int id, int subscribes, int subscribedTo, LocalDateTime subscribeTime) {
        this.id = id;
        this.subscribes = subscribes;
        this.subscribedTo = subscribedTo;
        this.subscribeTime = subscribeTime;
    }
}
