package com.fy.service.impl;

import com.fy.entity.Student;
import com.fy.mapper.StudentMapper;
import com.fy.service.StudentService;
import com.fy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public int addStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        if (isPhoneNum(student.getPhone())) {
            int num = mapper.addStudent(student);
            sqlSession.commit();
            sqlSession.close();
            return num;
        }else {
            return 100;
        }

    }

    @Override
    public List<Student> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.findAll();
        sqlSession.close();
        return students;
    }

    @Override
    public int deleteStudent(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int num = mapper.deleteStudent(id);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public Student findStudentById(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.findStudentById(id);
        sqlSession.close();
        return student;
    }

    @Override
    public int updateStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int num = mapper.updateStudent(student);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    /**
     * 手机号验证
     *
     * @param phoneNum
     * @return
     */
    public boolean isPhoneNum(String phoneNum) {
        Pattern PHONE_PATTERN = compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");
        Matcher m = PHONE_PATTERN.matcher(phoneNum);
        return m.matches();
    }
}
