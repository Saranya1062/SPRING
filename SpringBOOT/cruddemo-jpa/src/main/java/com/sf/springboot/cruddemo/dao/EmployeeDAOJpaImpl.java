package com.sf.springboot.cruddemo.dao;

import com.sf.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

   private EntityManager entityManager;

   public EmployeeDAOJpaImpl (EntityManager theEntityManager) {
       entityManager=theEntityManager;
   }
    @Override
    public List<Employee> findAll() {

        Query theQuery=entityManager.createQuery("from Employee");

        List<Employee> employee=theQuery.getResultList();
        return employee;
    }

    @Override
    public Employee findById(int theId) {

       Employee theEmployee=entityManager.find(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

       Employee dbEmployee=entityManager.merge(theEmployee);

       theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {

       Query theQuery=entityManager.createQuery("delete from Employee where id=:employeeId");

       theQuery.setParameter("employeeId",theId);

       theQuery.executeUpdate();
    }
}
