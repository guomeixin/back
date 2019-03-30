package com.neuedu.service;

import com.github.pagehelper.PageHelper;
import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
import com.neuedu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IUserImpl implements UserService {
    //@Resource
    @Autowired
    UserDao userDao;

    public User login(User user) {
        return userDao.login(user);
    }

    public int add(User user) {
        return userDao.add(user);
    }

    public int batch(List<User> users) {
        return userDao.batch(users);
    }

    @Override
    public Result list(User user) {
        PageHelper.startPage(user.getPageNo(),user.getPageSize() );
        Result result = new Result(userDao.list(user),user.getPageNo() ,userDao.count(user) ,user.getPageSize() );
        return result;
    }

}
