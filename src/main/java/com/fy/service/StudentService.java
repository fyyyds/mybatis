package com.fy.service;

import com.fy.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     *添加方法
     * @param student
     * @return
     */
    int addStudent(Student student);

    /**
     * 查找全部方法
     * @return
     */
    List<Student> findAll();

    /**
     * 删除学生方法
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
