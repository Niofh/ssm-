package com.oufuhua.service.impl;

import com.oufuhua.dao.UserDao;
import com.oufuhua.dto.UserDto;
import com.oufuhua.model.User;
import com.oufuhua.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/6/25 16:39
 */
@Service
public class UserServiceImpl implements UserServer {

    @Value("${config.savePath}")
    private String configSavePath;

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public void addUser(UserDto userDto) throws Exception {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setBirthday(userDto.getBirthday());

        if (userDto.getFile() != null && userDto.getFile().getSize() > 0) {

            // 文件夹目录
            File fileFolder = new File(configSavePath);

            // 文件不存在，就创建多级目录
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }

            String fileName = System.currentTimeMillis() + "_" + userDto.getFile().getOriginalFilename();

            // 定义文件的路径
            File file = new File(configSavePath, fileName);

            // 文件转移到自定义文件目录
            userDto.getFile().transferTo(file);

            // 文件名称
            user.setImgName(fileName);
            userDao.addUser(user);

        } else {
            throw new Exception("图片不能为空");
        }


    }
}
