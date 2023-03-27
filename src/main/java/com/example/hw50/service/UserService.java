package com.example.hw50.service;

import com.example.hw50.dao.UserDao;
import com.example.hw50.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao usersDao;
    private final PasswordEncoder encoder;
    public UserDto getUserByEmail(String email){
        return UserDto.from(usersDao.findUserByEmail(email));
    }

    public UserDto getUserByName(String name){
        return UserDto.from(usersDao.findUsersByName(name));
    }

    public UserDto getUserByNickName(String nickName){
        return UserDto.from(usersDao.findUserByAccountName(nickName));
    }

    public String isRegisteredEmail(String email){
        return usersDao.isRegisteredEmail(email);
    }
}
