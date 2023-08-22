// This code snippet defines an interface for a StudentDAO, which provides methods for saving, finding by ID, finding all, and finding by last name for Student entities.
package com.springcourse.cruddemo.dao;

import java.util.List;

import com.springcourse.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findBYId(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(student theStudent);

}
