package com.oufuhua.service;

import com.oufuhua.model.Student;

import java.util.List;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/6/25 16:39
 */
public interface StudentServer {
    public List<Student> getStudent(Integer pageIndex, Integer pageSize, String name);
    /**
     * 获取学生的总数量
     *
     * @return 学生的数量
     */
    public Integer getStudentNumber();
}
