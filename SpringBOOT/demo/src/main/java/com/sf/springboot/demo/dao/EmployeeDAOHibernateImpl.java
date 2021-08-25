package com.sf.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.ws.Response;

import com.sf.springboot.demo.dao.EmployeeDAO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;

import com.sf.springboot.demo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> theQuery =
				currentSession.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results		
		return employees;
	}


	@Override
	public Employee findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee theEmployee =
				currentSession.get(Employee.class, theId);
		
		// return the employee
		return theEmployee;
	}


	@Override
	public void save(Employee theEmployee) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theEmployee);
	}


	@Override
	public void deleteById(int theId) {

		try {
			Session currentSession = entityManager.unwrap(Session.class);

			String test = "deleted from Employee where id=:employeeId";

			//if(test=="delete from Employee where id=:employeeId") {

			Query theQuery =
					currentSession.createQuery(test);
			theQuery.setParameter("employeeId", theId);

			theQuery.executeUpdate();
		}catch (Exception e) {
			throw new RuntimeException("Contact administrator");
		}
		//	}
			//else {
			//	throw new Error("Contact administrator");
			//}
	}
}







