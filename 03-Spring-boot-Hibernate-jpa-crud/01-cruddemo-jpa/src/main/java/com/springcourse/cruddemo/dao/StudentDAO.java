package com.springcourse.cruddemo.dao;

import com.springcourse.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findBYId(Integer id);
}
