package com.example.hw50.dto;

import com.example.hw50.entity.Subscription;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscriptionDto {
    private int id;
    private int subscribes;
    private int subscribedTo;
    private LocalDateTime subscribeTime;

    public static SubscriptionDto from(Subscription subs) {
        return builder()
                .id(subs.getId())
                .subscribes(subs.getSubscribes())
                .subscribedTo(subs.getSubscribedTo())
                .subscribeTime(subs.getSubscribeTime())
                .build();
    }
}
