package com.oufuhua.service.impl;

import com.oufuhua.dao.StudentDao;
import com.oufuhua.model.Student;
import com.oufuhua.service.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/6/25 16:39
 */
@Service
public class StudentServiceImpl implements StudentServer {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudent(Integer pageIndex, Integer pageSize, String name) {

        return studentDao.getStudent(pageIndex, pageSize, name);
    }

    @Override
    public Integer getStudentNumber() {
        return studentDao.getStudentNumber();
    }
}
