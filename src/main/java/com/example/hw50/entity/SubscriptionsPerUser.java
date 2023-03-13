package com.example.hw50.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SubscriptionsPerUser {
    private int id;
    private User subscribes;
    private User subscribedTo;
    private LocalDateTime subscribeTime;

    public SubscriptionsPerUser(int id, User subscribes, User subscribedTo, LocalDateTime subscribeTime) {
        this.id = id;
        this.subscribes = subscribes;
        this.subscribedTo = subscribedTo;
        this.subscribeTime = subscribeTime;
    }
}
