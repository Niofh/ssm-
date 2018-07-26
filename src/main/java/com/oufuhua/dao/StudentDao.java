package com.oufuhua.dao;

import com.oufuhua.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {


    /**
     * 根据搜索查询学生分页列表
     *
     * @param pageIndex 当前页
     * @param pageSize  每页显示几条数据
     * @param name      模糊搜索
     * @return 学生列表
     */
    public List<Student> getStudent(
            @Param("pageIndex") Integer pageIndex,
            @Param("pageSize") Integer pageSize,
            @Param("name") String name
    );


    /**
     * 获取学生的总数量
     *
     * @return 学生的数量
     */
    public Integer getStudentNumber(@Param("name") String name);

    /**
     * 使用插件的分页，只需要传递搜索参数就可以
     *
     * @param name 学生名称
     * @return 学生列表
     */
    public List<Student> selectStudentPlug(@Param("name") String name);

}
