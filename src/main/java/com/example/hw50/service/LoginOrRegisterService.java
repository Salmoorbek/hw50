package com.example.hw50.service;

import com.example.hw50.dao.UserDao;
import com.example.hw50.dto.UserDto;
import com.example.hw50.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginOrRegisterService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    public String author(String email, String password){
        List<UserDto> userDtos = userDao.login(email, password);
        if(userDtos!=null)
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
                .countFollower(0)
                .countPublication(0)
                .countPublication(0)
                .build();

        userDao.register(usr);
        return UserDto.from(usr);
    }
}
