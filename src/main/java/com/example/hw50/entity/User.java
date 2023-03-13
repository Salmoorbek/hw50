package com.example.hw50.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private int countPublication;
    private int countSubscription;
    private int countFollower;

    public User(int id, String name, String email, String password, int countPublication, int countSubscription, int countFollower) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.countPublication = countPublication;
        this.countSubscription = countSubscription;
        this.countFollower = countFollower;
    }
}
