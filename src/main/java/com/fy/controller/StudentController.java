package com.fy.controller;

import com.fy.entity.Student;
import com.fy.service.StudentService;
import com.fy.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService = new StudentServiceImpl();

    public int addStudent(Student student) {
        int number = studentService.addStudent(student);
        return number;
    }

    public List<Student> findAll() {
        List<Student> list = studentService.findAll();
        return list;
    }

    public int deleteStudent(String id) {
        int number = studentService.deleteStudent(id);
        return number;
    }

    public Student findStudentById(String id) {
        Student student = studentService.findStudentById(id);
        return student;
    }

    public int updateStudent(Student student) {
        int number = studentService.updateStudent(student);
        return number;
    }
}


