package com.cruddemojpa.demo.dao;

import com.cruddemojpa.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);
    public Student findById(Integer Id);

    public List<Student> findByLastName(String lastName);
    public void update(Student student);

    public void delete(Integer id);

    int deleteAll();
}
