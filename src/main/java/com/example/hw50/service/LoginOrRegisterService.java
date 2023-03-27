package com.example.hw50.service;

import com.example.hw50.dao.UserDao;
import com.example.hw50.dto.UserDto;
import com.example.hw50.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginOrRegisterService {
    private final UserDao userDao;

    public String author(String accname, String password) {
        UserDto userDtos = UserDto.from(userDao.login(accname, password));
        if (userDtos != null)
            return "Вы зашли";
        else
            return "Такого пользователя нет";
    }

    public UserDto register(User user) {
        var usr = User.builder()
                .id(userDao.getAllUsers().size() + 1)
                .name(user.getName())
                .email(user.getEmail())
                .accName(user.getAccName())
                .password(user.getPassword())
                .enabled(Boolean.TRUE)
                .countFollower(user.getCountFollower())
                .countPublication(user.getCountPublication())
                .countSubscription(user.getCountSubscription())
                .build();

        userDao.register(usr);
        return UserDto.from(usr);
    }
}
