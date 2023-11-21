package com.example.vijayi.ums.service;

import com.example.vijayi.ums.api.resources.UserDto;
import com.example.vijayi.ums.db.model.User;

public interface UserService
{
    boolean createUser(User user);
}
