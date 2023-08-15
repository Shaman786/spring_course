package com.springcourse.cruddemo.dao;

import java.util.List;

import com.springcourse.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findBYId(Integer id);

    List<Student> findAll();
}
