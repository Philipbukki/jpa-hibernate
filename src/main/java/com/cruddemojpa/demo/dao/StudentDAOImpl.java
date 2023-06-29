package com.cruddemojpa.demo.dao;

import com.cruddemojpa.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }


    @Override
    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }
    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findByLastName(String lastName){
        TypedQuery query = entityManager.createQuery("FROM Student WHERE lastName =:theData"
                ,Student.class);
        query.setParameter("theData",lastName);

        List<Student> students = query.getResultList();
        return students;



    }

    @Override
    @Transactional
    public void update(Student student) {

        entityManager.merge(student);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
//        find student with the given id
        Student theStudent = entityManager.find(Student.class,id);
//        delete the student from the db
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsDeleted = entityManager.createQuery("DELETE FROM Student")
                .executeUpdate();
        return rowsDeleted;
    }
}
