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
public class SubscriptionsPerUser {
    private int id;
    private int subscribes;
    private int subscribedTo;
    private LocalDateTime subscribeTime;

    public SubscriptionsPerUser(int id, int subscribes, int subscribedTo, LocalDateTime subscribeTime) {
        this.id = id;
        this.subscribes = subscribes;
        this.subscribedTo = subscribedTo;
        this.subscribeTime = subscribeTime;
    }
}
