package com.example.hw50.service;

import com.example.hw50.dao.UserDao;
import com.example.hw50.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
}
