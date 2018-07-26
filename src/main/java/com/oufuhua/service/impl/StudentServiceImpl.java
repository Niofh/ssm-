package com.oufuhua.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oufuhua.dao.StudentDao;
import com.oufuhua.model.Pager;
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
    public Integer getStudentNumber(String name) {
        return studentDao.getStudentNumber(name);
    }

    @Override
    public  Pager<Student> selectStudentPlug(Integer pageIndex, Integer pageSize, String name) {
        //设置分页条件，Parameters:pageNum 页码pageSize 每页显示数量count 是否进行count查询

        PageHelper.startPage(pageIndex * pageSize, pageSize, true);
        List<Student> studentList = studentDao.selectStudentPlug(name);

        PageInfo<Student> studentPageInfo = new PageInfo<Student>(studentList);

        System.out.println( studentPageInfo);

        Pager<Student> studentPager = new Pager<>();
        studentPager.setTotalRecord((int) studentPageInfo.getTotal());
        studentPager.setDataList(studentList);
        studentPager.setTotalPage(studentPageInfo.getPages());
        studentPager.setPageIndex(pageIndex);
        studentPager.setPageSize(pageSize);

        return studentPager;
    }
}
