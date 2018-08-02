package com.oufuhua.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oufuhua.dao.StudentDao;
import com.oufuhua.common.model.Pager;
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
    public  Pager<Student> selectStudentPlug(Pager<Student> pager, String name) {
        //设置分页条件，Parameters:pageNum 页码pageSize 每页显示数量count 是否进行count查询

        PageHelper.startPage(pager.getPageNum(), pager.getPageSize(), true);

        // 获取集合
        List<Student> studentList = studentDao.selectStudentPlug(name);

        // 获取详细信息
        PageInfo<Student> studentPageInfo = new PageInfo<Student>(studentList);
        pager.setTotalRecord((int) studentPageInfo.getTotal());
        pager.setDataList(studentList);
        pager.setTotalPage(studentPageInfo.getPages());

        return pager;
    }
}
