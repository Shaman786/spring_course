package com.shaman.cruddemo.DAO;

import com.shaman.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    // define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee ", Employee.class);
        //execute a query and get result list
        List<Employee> employees = theQuery.getResultList();
        // return the results
        return employees;
    }

    @Override
    public Employee findByID(int theId) {
        // get employee
        // return employee
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        entityManager.remove(findByID(theId));
    }
}
