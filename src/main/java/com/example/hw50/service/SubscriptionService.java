package com.example.hw50.service;

import com.example.hw50.dao.SubscriptionDao;
import com.example.hw50.dto.SubscriptionDto;
import com.example.hw50.entity.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionDao subscriptionDao;

    public SubscriptionDto followForUser(int subsId, int subsToId) {
        var subs = Subscription.builder()
                .id(subscriptionDao.getAllSubs().size() + 1)
                .subscribes(subsId)
                .subscribedTo(subsToId)
                .subscribeTime(LocalDateTime.now())
                .build();
        subscriptionDao.save(subs);
        return SubscriptionDto.from(subs);
    }
}
