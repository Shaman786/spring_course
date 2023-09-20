package com.shaman.cruddemo.service;

import com.shaman.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findByID(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
