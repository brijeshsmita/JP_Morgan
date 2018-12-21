package com.smita.springboot.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.smita.springboot.entities.Employee;
import com.smita.springboot.exception.EmployeeException;
/** @author Smita **/
//prep-work 1- @Repository EmployeeDao
@Repository
public class EmployeeDao implements IEmployeeDao {
	//prep-work 2 -> @PersistenceContext EnttityManager Object
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Long addEmployee(Employee employee) throws EmployeeException {
		entityManager.persist(employee);
		return employee.getEmployeeId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		Query query = entityManager.createQuery("from Employee");
		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, empId);
	}

	@Override
	public boolean updateEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
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
}
