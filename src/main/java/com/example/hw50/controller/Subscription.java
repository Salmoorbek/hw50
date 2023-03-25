package com.example.hw50.controller;

import com.example.hw50.dto.SubscriptionDto;
import com.example.hw50.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class Subscription {

    private final SubscriptionService service;

    @GetMapping("/subscribe/{subsId}/{subsToId}")
    public SubscriptionDto takePublicationsForUserBySubscriptions(@PathVariable int subsId, @PathVariable int subsToId) {
        return service.followForUser(subsId, subsToId);
    }
}
