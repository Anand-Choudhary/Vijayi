package com.example.vijayi.ums.service.impl;

import com.example.vijayi.ums.api.resources.UserDto;
import com.example.vijayi.ums.db.dao.UserDao;
import com.example.vijayi.ums.db.model.User;
import com.example.vijayi.ums.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;
    @Override
    public boolean createUser(User user) {
        userDao.save(user);
        return true;
    }
}
