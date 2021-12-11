package com.fy.mapper;

import com.fy.entity.Student;

import java.util.List;

/**
 * @author Administrator
 */
public interface StudentMapper {

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    int addStudent(Student student);

    /**
     * 查找全部
     *
     * @return
     */
    List<Student> findAll();

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteStudent(String id);

    /**
     * 根据id查找学生
     * @param id
     * @return
     */
    Student findStudentById(String id);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    int updateStudent(Student student);
}
