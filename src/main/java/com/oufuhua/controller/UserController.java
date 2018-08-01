package com.oufuhua.controller;

import com.oufuhua.dto.UserDto;
import com.oufuhua.model.User;
import com.oufuhua.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/6/25 16:37
 */
@Controller
public class UserController {

    @Autowired
    private UserServer userServer;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/")

    public String index(Locale locale) {
        // 获取对应的国际化信息

        // code 相当于属性key , args：传递参数， 模板：{0}-{1}；示例：{"haha","哦哦"}。
        // defaultMessage：默认语言：英语
        String val = messageSource.getMessage("username", null, "en_Us", locale);
        System.out.println(val);
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
