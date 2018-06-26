package com.oufuhua.dao;

import com.oufuhua.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/6/25 16:11
 */

@Repository
public interface UserDao {

    /**
     * 获取所有用户
     *
     * @return List<User>
     */
    public List<User> selectAllUser();


    public void addUser(User user);
}
