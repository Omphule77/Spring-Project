package com.restcrud.project.restcrudeproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restcrud.project.restcrudeproject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  //no need to write any code bcoz it already extended
}
