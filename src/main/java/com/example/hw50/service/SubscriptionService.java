package com.example.hw50.service;

import com.example.hw50.dao.SubscriptionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionDao subscriptionDao;
}
