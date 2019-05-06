package com.smita.springboot.dao;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.smita.springboot.entities.Employee;
import com.smita.springboot.exception.EmployeeAlreadyExistsException;
import com.smita.springboot.exception.EmployeeException;
/** @author Smita **/
//prep-work 1- @Repository EmployeeDao
@Repository
public class EmployeeDao implements IEmployeeDao {
	private final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);
	//prep-work 2 -> @PersistenceContext EnttityManager Object
	@PersistenceContext
	private EntityManager entityManager;	
	
	@Override
	public Long addEmployee(Employee employee) throws EmployeeException {
		logger.info("Trying to persist employee at dao addEmployee method");
		try {
		entityManager.persist(employee);
		logger.info("Persisted employee at dao addEmployee method with unique Id : "+employee.getEmployeeId());
		}catch (Exception e) {
			logger.error("Failed to persist employee at dao addEmployee method");
		}
		return employee.getEmployeeId();
	}	
	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		Query query = entityManager.createQuery("from Employee");
		return query.getResultList();
	}
	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		return entityManager.find(Employee.class, empId);
	}
	@Override
	public boolean updateEmployee(Employee employee) throws EmployeeException {
		return entityManager.merge(employee)!=null;
	}
	@Override
	public boolean deleteEmployeeById(Long empId) throws EmployeeException {
		Employee employee =getEmployeeById(empId);
		if(employee!=null)
			return false;
		else {
			entityManager.remove(employee);
			return true;
		}
	}
	@Override
	public Employee createEmp(Employee employee) throws EmployeeException, EmployeeAlreadyExistsException {
		try {
		entityManager.persist(employee);
		}catch (DataIntegrityViolationException e) {

            for (Throwable t = e.getCause(); t != null; t = t.getCause()) {

                if (SQLException.class.equals(t.getClass())) {
                    SQLException sqlException = (SQLException) t;

                    // In Postgres SQLState 23505=unique_violation
                    if ("23505".equals(sqlException.getSQLState())) {
                        throw new EmployeeAlreadyExistsException("YourErrorCode", e);
                    }
                }
            }
            throw new EmployeeException("YourErrorCode2 : "+e);

        }
		return employee;
	}
}
