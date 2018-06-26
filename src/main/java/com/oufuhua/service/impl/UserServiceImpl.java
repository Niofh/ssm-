package com.oufuhua.service.impl;

import com.oufuhua.dao.UserDao;
import com.oufuhua.model.User;
import com.oufuhua.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/6/25 16:39
 */
@Service
public class UserServiceImpl implements UserServer {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
