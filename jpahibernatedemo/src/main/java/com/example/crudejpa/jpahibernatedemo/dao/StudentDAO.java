package com.example.crudejpa.jpahibernatedemo.dao;

import java.util.List;

import com.example.crudejpa.jpahibernatedemo.entity.Student;

public interface StudentDAO {
  void save(Student student);
  Student findById(Integer id);
  List<Student> findAll();
  List<Student> findByLastName(String LName);
  void update(Student theStudent);
  void delete(Integer id);
  int deleteAll();
}
