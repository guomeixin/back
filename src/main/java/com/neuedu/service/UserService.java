package com.neuedu.service;

import com.neuedu.pojo.User;

import java.util.List;

public interface UserService {
    User login(User user);
    int  add(User user);
    int batch(List<User> users);
    List<User> list();
}
