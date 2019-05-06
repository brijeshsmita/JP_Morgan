package com.smita.springboot.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/** @author Smita 
 * CREATE Table emp_rest(

employee_id numeric(6) primary key,
	
name varchar(30),

salary numeric(6,2));**/
@Entity // tell JPA that this class object need to be persisted
@Table(name="emp_rest") // tell JPA that this class object need to be mapped with this table
public class Employee {
	@Id //Primary key
	//@GeneratedValue(strategy=GenerationType.TABLE)
	@SequenceGenerator(name="EMP_GEN" ,
	sequenceName="emp_rest_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, 
	generator="EMP_GEN")
	@Column(name="employee_id")
	private Long employeeId;
	
	@NotNull(message="Employee Name is Null!")
	@Size(min=3,max=30,message="Employee Name should be min 3 and max 30 characters only")
	@Pattern(regexp="[a-zA-Z]*",message="Employee Name should be only character")
	private String name;
	
	@Min(value=3,message="Employee Salary should be min 3 digits")
	//@Max(value=4,message="Employee Salary should be max 4 digits")
	private Double salary;
//no-arg constr	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	//overloaded constr
	public Employee(Long employeeId, String name, Double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(String name, Double salary) {
			super();
			this.name = name;
			this.salary = salary;
		}
//getters and setters
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	//toString()
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
