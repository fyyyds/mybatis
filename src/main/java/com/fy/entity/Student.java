package com.fy.entity;


/**
 * (Student)实体类
 *
 * @since 2021-12-03 14:47:29
 */

public class Student {

    private String id;
    
    private String name;
    
    private String major;
    
    private String phone;

    public Student() {
    }

    public Student(String id, String name, String major, String phone) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}