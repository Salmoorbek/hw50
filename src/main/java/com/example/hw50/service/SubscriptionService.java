package com.example.hw50.service;

import com.example.hw50.dao.SubscriptionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionDao subscriptionDao;

    public void followForUser(){
        // TODO: 20/3/23 подписываться на других пользователей, что бы видеть их публикации у себя в ленте 
    }
}
