package com.oufuhua.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oufuhua.common.orm.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/6/25 17:16
 */

@JsonInclude(JsonInclude.Include.NON_NULL)  // null值属性不返回出去
public class User extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -6784872932530367108L;

    private Integer id;
    private String username;
    private Date birthday;
    private String imgName; // 图片名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", imgName='" + imgName + '\'' +
                '}';
    }
}
