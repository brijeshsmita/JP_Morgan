package com.smita.springboot.service;
import java.util.List;
import com.smita.springboot.entities.Employee;
import com.smita.springboot.exception.EmployeeAlreadyExistsException;
import com.smita.springboot.exception.EmployeeException;
/** @author Smita **/
public interface IEmployeeService {
	//CRUDS Operation
	public Long addEmployee(Employee employee)throws EmployeeException;//C-create
	public List<Employee> getEmployeeList()throws EmployeeException;//R All Employee -retrieve
	public boolean updateEmployee(Employee employee)throws EmployeeException;//U-update
	public boolean deleteEmployeeById(Long empId)throws EmployeeException;//D-delete
	public Employee getEmployeeById(Long empId)throws EmployeeException;//S-search
	public Employee createEmp(Employee employee)throws EmployeeException,EmployeeAlreadyExistsException;
}
