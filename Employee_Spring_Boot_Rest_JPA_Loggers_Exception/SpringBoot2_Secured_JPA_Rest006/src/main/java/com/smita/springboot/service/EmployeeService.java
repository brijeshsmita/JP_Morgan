package com.smita.springboot.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.smita.springboot.dao.IEmployeeDao;
import com.smita.springboot.entities.Employee;
import com.smita.springboot.exception.EmployeeAlreadyExistsException;
import com.smita.springboot.exception.EmployeeException;
/** @author Smita **/
//prepwork 1- @Service EmployeeService
@Service
public class EmployeeService implements IEmployeeService {
//prepwork 2- @Autowired IEmployeeDao
	@Autowired
	private IEmployeeDao employeeDao;
	
	@Override
	@Transactional
	// prepwork 3- @Transactional all method (@Transactional 
	//we have to import from	// springFramework)
	public Long addEmployee(Employee employee) throws EmployeeException {
		// prepwork 4- call dao layer method and return to Client
		return employeeDao.addEmployee(employee);// auto generated emp id will be returned
	}
	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		// call Dao layer method and return to Service layer
		return employeeDao.getEmployeeList();
	}
	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		// call Dao layer method and return to Service layer
		return employeeDao.getEmployeeById(empId);
	}
	@Override
	@Transactional
	public boolean updateEmployee(Employee employee) throws EmployeeException {
		return employeeDao.updateEmployee(employee);
	}
	@Override
	@Transactional
	public boolean deleteEmployeeById(Long empId) throws EmployeeException {
		return employeeDao.deleteEmployeeById(empId);
	}
	@Override
	@Transactional
	public Employee createEmp(Employee employee) throws EmployeeException, EmployeeAlreadyExistsException {
		return employeeDao.createEmp(employee);
	}

}
