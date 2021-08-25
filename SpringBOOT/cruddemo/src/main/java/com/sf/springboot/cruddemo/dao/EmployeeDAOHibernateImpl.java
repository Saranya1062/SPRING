package com.sf.springboot.cruddemo.dao;

import com.sf.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired                           // EM automatically created by SB & inject it here into our application
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {     // here construct injection is used
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //get the session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        //update
        List<Employee> employees = theQuery.getResultList();

        //return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee theEmployee=currentSession.get(Employee.class,theId);

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(int theId){

                Session currentSession = entityManager.unwrap(Session.class);

                Query theQuery = currentSession.createQuery("delete from employee where id=:employeeId");

                theQuery.setParameter("employee",theId);

                theQuery.executeUpdate();
    }
}
