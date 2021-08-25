package com.sf.springboot.cruddemo.dao;    //2

import com.sf.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
   public List<Employee> findAll();     // this method is for return a list of employees

   public Employee findById(int theId);

   public void save(Employee theEmployee);

   public void deleteById(int theId);
}
