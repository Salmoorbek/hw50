package com.example.hw50.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
    private String accName;
    private String password;
    private Boolean enabled = Boolean.TRUE;
    private int countPublication;
    private int countSubscription;
    private int countFollower;

    public User(int id, String name, String email, String accName, String password, Boolean enabled, int countPublication, int countSubscription, int countFollower) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accName = accName;
        this.password = password;
        this.enabled = enabled;
        this.countPublication = countPublication;
        this.countSubscription = countSubscription;
        this.countFollower = countFollower;
    }
}
