package com.sf.springboot.cruddemo.service;

import com.sf.springboot.cruddemo.dao.EmployeeRepository;
import com.sf.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    public EmployeeRepository employeeRepository;

    public EmployeeServiceImpl (EmployeeRepository theEmployeeRepository) {
        employeeRepository=theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee=null;
        if(result.isPresent()) {
            theEmployee= result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
