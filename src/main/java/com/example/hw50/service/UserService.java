package com.example.hw50.service;

import com.example.hw50.dao.UserDao;
import com.example.hw50.dto.UserDto;
import com.example.hw50.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao usersDao;
    public User getUserByEmail(String email){
        return usersDao.findUserByEmail(email);
    }

    public User getUserByName(String name){
        return usersDao.findUsersByName(name);
    }

    public User getUserByNickName(String nickName){
        return usersDao.findUserByAccountName(nickName);
    }

    public String isRegisteredEmail(String email){
        return usersDao.isRegisteredEmail(email);
    }

    public String author(String email, String password){
        List<UserDto> userDtos = usersDao.login(email, password);
        if(userDtos!=null)
            return "Вы зашли";
        else
            return "Такого пользователя нет";
    }
    public UserDto register(User user) {
        var usr = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .accName(user.getAccName())
                .password(user.getPassword())
                .countFollower(0)
                .countPublication(0)
                .countPublication(0)
                .build();

        usersDao.register(usr);
        return UserDto.from(usr);
    }
}
