package com.springcourse.cruddemo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcourse.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository // This annotation is used to indicate that the class is a Data Access Object
            // (DAO). It's a specialization of the @Component annotation, indicating that
            // this class is responsible for database operations.
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional // This annotation is used to define the scope of a single database transaction.
                   // In this case, the save method will be executed within a transaction, ensuring
                   // data consistency and integrity.
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

}
