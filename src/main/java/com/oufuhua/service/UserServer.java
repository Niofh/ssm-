package com.oufuhua.service;

import com.oufuhua.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/6/25 16:39
 */
public interface UserServer {
    public List<User> selectAllUser();
    public void addUser(User user);
}
