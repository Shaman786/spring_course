package com.shaman.curddemo.service;

import com.shaman.curddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findByID(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
