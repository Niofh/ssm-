package com.oufuhua.model;

import java.io.Serializable;

public class Student implements Serializable {


    private static final long serialVersionUID = 4846068174194960165L;

    private Integer id; // 学生id

    private String stuName; // 学生姓名

    private Integer age; // 学生姓名

    private Integer gender; // 学生性别

    private String address; // 学生地址

    public Student() {
    }

    public Student(Integer id, String stuName, Integer age, Integer gender, String address) {
        this.id = id;
        this.stuName = stuName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
