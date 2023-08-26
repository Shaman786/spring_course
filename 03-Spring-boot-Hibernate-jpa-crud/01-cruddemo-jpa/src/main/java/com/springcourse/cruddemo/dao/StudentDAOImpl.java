package com.springcourse.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcourse.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository // This annotation is used to indicate that the class is a Data Access Object
// (DAO). It's a specialization of the @Component annotation, indicating that
// this class is responsible for database operations.
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private final EntityManager entityManager;

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

    @Override
    public Student findBYId(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ", Student.class);
        // return query results

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
//        create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student  where lastName=:theData", Student.class);
//        set query parameters
        theQuery.setParameter("theData", theLastName);
//        return query results

        return theQuery.getResultList();
    }


    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge((theStudent));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
//      retrieve the student
        Student theStudent = entityManager.find(Student.class, id);
//        delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll(){
        return entityManager.createQuery("delete  from Student ").executeUpdate();
    }

}
