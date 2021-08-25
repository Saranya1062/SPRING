package com.sf.springboot.cruddemo.service;

import com.sf.springboot.cruddemo.dao.EmployeeDAO;
import com.sf.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    public EmployeeDAO employeeDAO;

    public EmployeeServiceImpl (@Qualifier("employeeDAOJpaImpl") EmployeeDAO theEmployeeDAO) {
        employeeDAO=theEmployeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
         employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
         employeeDAO.deleteById(theId);
    }
}
