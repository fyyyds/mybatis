package com.fy;


import com.fy.controller.StudentController;
import com.fy.entity.Student;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class StudentManagerSystem {
    public static final Scanner scanner = new Scanner(System.in);
    public static StudentController studentController = new StudentController();

    public static void main(String[] args) {
        menu();
    }

    /**
     * 添加
     */
    public static void addStudent() {
        System.out.println("请输入学生ID：");
        String id = scanner.next();
        //id是否是数字
        if (idIsNum(id)) {
            Student exist = studentController.findStudentById(id);
            //id是否存在
            if (exist != null) {
                System.out.println("id已存在");
            } else {
                System.out.println("请输入学生姓名：");
                String name = scanner.next();
                System.out.println("请输入学生专业：");
                String major = scanner.next();
                System.out.println("请输入学生手机号：");
                String phone = scanner.next();
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setMajor(major);
                student.setPhone(phone);
                int num = studentController.addStudent(student);
                if (num == 1) {
                    System.out.println("添加成功");
                } else if (num == 100) {
                    System.out.println("添加失败");
                    System.out.println("手机号格式错误");
                }
            }
        } else {
            System.out.println("id错误");
        }
    }


    /**
     * 查找全部
     */
    public static void findAll() {
        List<Student> list = studentController.findAll();
        System.out.println("学生信息：");
        for (Student student : list) {
            System.out.println(student);
        }
    }

    /**
     * 删除
     */
    public static void deleteStudent() {
        System.out.println("输入删除学生的id：");
        String id = scanner.next();
        if (idIsNum(id)) {
            Student exist = studentController.findStudentById(id);
            if (exist != null) {
                studentController.deleteStudent(id);
                System.out.println("删除成功");
            } else if (exist == null) {
                System.out.println("学生不存在");
            }
        } else {
            System.out.println("id错误");
        }
    }

    /**
     * 通过id查找学生
     */
    public static void findStudentById() {
        System.out.println("输入查找学生的id:");
        String id = scanner.next();
        if (idIsNum(id)) {
            Student exist = studentController.findStudentById(id);
            if (exist != null) {
                Student student = studentController.findStudentById(id);
                System.out.println("查询成功");
                System.out.println(student);
            } else if (exist == null) {
                System.out.println("学生不存在");
            }
        } else {
            System.out.println("id错误");
        }
    }

    /**
     * 修改
     */
    public static void updateStudent() {
        System.out.println("输入修改学生的id:");
        String id = scanner.next();
        if (idIsNum(id)) {
            Student exist = studentController.findStudentById(id);
            if (exist != null) {
                Student student = studentController.findStudentById(id);
                System.out.println(student);
                System.out.println("请输入修改后学生姓名：");
                String name = scanner.next();
                System.out.println("请输入修改后学生专业：");
                String major = scanner.next();
                System.out.println("请输入修改后学生手机号：");
                String phone = scanner.next();

                Student student1 = new Student(id, name, major, phone);
                int num = studentController.updateStudent(student1);
                if (num == 1) {
                    Student student2 = studentController.findStudentById(id);
                    System.out.println("修改成功");
                    System.out.println(student2);
                } else if (num == 100) {
                    System.out.println("修改失败");
                    System.out.println("手机号格式错误");
                }
            } else if (exist == null) {
                System.out.println("学生不存在");
            }
        } else {
            System.out.println("id错误");
        }
    }

    /**
     * 菜单
     */
    public static void menu() {
        System.out.println("=============================");
        System.out.println("1.增加学生信息");
        System.out.println("2.查找所有学生信息");
        System.out.println("3.删除学生信息");
        System.out.println("4.按id查找学生信息");
        System.out.println("5.修改学生信息");
        System.out.println("0.退出");
        System.out.println("=============================");

        int chance = scanner.nextInt();
        switch (chance) {
            case 1:
                addStudent();
                menu();
            case 2:
                findAll();
                menu();
            case 3:
                deleteStudent();
                menu();
            case 4:
                findStudentById();
                menu();
            case 5:
                updateStudent();
                menu();
            case 0:
                break;
            default:
                menu();
        }
    }

    /**
     * 判断id是否是数字
     *
     * @param id
     * @return
     */
    public static boolean idIsNum(String id) {
        Pattern pattern = compile("[0-9]*");
        Matcher m = pattern.matcher(id);
        return m.matches();
    }
}

