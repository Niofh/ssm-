package com.oufuhua.controller;

import com.oufuhua.dto.UserDto;
import com.oufuhua.model.User;
import com.oufuhua.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/6/25 16:37
 */
@Controller
public class UserController {

    @Autowired
    private UserServer userServer;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String add(UserDto userDto) {
        System.out.println("哈哈");
        try {
            userServer.addUser(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }


    @RequestMapping("/user/getAllUser")
    @ResponseBody
    public List<User> getAllUser() {
        return userServer.selectAllUser();
    }
}
