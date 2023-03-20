package com.example.hw50.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    private int id;
    private int subscribes;
    private int subscribedTo;
    private LocalDateTime subscribeTime;

}
