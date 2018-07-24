package com.oufuhua.controller;


import com.oufuhua.model.Pager;
import com.oufuhua.model.Student;
import com.oufuhua.service.StudentServer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentServer studentServer;

    @RequestMapping("/student")
    @ResponseBody
    public Pager<Student> getStudent(@Param("pageIndex") Integer pageIndex,
                                     @Param("pageSize") Integer pageSize,
                                     @Param("name") String name) {


        return getPager(pageIndex, pageSize, name);
    }


    /**
     * 获取学生的分页数据
     *
     * @param pageIndex
     * @param pageSize
     * @param name
     * @return
     */
    private Pager<Student> getPager(Integer pageIndex, Integer pageSize, String name) {
        // 获取总数量
        Integer studentNumber = studentServer.getStudentNumber();

        // 获取条件后的学生列表
        List<Student> student = studentServer.getStudent(pageIndex, pageSize, name);

        Pager<Student> studentPager = new Pager<>();
        pageIndex = (pageIndex - 1) * pageSize;

        studentPager.setTotalRecord(studentNumber);
        studentPager.setDataList(student);
        studentPager.setPageIndex(pageIndex);
        studentPager.setPageSize(pageSize);

        // 因为3/10无限循环小数，先要转化double才能做其他计算
        double totalPage = Math.ceil((double)studentNumber / pageSize);

        studentPager.setTotalPage((int) totalPage);

        return studentPager;
    }
}
