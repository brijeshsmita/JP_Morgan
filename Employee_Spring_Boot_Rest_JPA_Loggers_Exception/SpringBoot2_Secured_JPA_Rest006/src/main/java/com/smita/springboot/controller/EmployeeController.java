package com.smita.springboot.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.smita.springboot.entities.Employee;
import com.smita.springboot.exception.EmployeeAlreadyExistsException;
import com.smita.springboot.exception.EmployeeException;
import com.smita.springboot.service.IEmployeeService;

/** @author Smita **/
/*
 * This @CrossOrigin annotation enables cross-origin requests only for
 * controller or the specific method. By default, its allows all origins, all
 * headers, the HTTP methods specified in the @RequestMapping annotation and a
 * maxAge of 30 minutes is used. You can customize this behavior by specifying
 * the value of one of the annotation attributes: origins, methods,
 * allowedHeaders, exposedHeaders, allowCredentials or maxAge. In this example,
 * we only allow http://localhost:8082 to send cross-origin requests.
 */
// prep-work 1> @CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
// prep-work 2> @RestController
@RestController
// prep-work 3> @RequestMapping
@RequestMapping("/api/employees")
public class EmployeeController {
	// prep-work 4> @Autowired IEmployeeService
	@Autowired
	private IEmployeeService employeeService;

	// http://localhost:8082/api/employees/
	@GetMapping(value = "", produces = "application/json")
	public List<Employee> getAll() throws EmployeeException {
		List<Employee> empList=null;
		try {
			empList=employeeService.getEmployeeList();
			if(!empList.isEmpty()) {
				return empList;
			}else {
				System.out.println("Empty List of employees " );
				throw new EmployeeException("Empty List of employees " );
			}
		
		} catch (EmployeeException e) {
			throw new EmployeeException(
					"Error while fechting List employee : "+e.getLocalizedMessage());
		}
		
	}

	// http://localhost:8082/api/employees/1
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "employeeId") Long employeeId)
			throws EmployeeException {
		try {
			System.out.println("EmployeeController -> find : " + employeeId);
			Employee employee = employeeService.getEmployeeById(employeeId);
			return ResponseEntity.ok().body(employee);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
					"Error while Finding employee By Id: " + e.getLocalizedMessage());
		}
	}
	

	// http://localhost:8082/api/employees/save
	@PostMapping("/save")
	public HttpStatus saveEmployee(@RequestBody Employee employee) throws EmployeeException {
		// ccondition ? yes:no
		try {
			return employeeService.addEmployee(employee) != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
					"Error while Adding employee : " + e.getLocalizedMessage());
		}
	}

	// http://localhost:8082/api/employees/1
	@PutMapping("/{employeeId}")
	public HttpStatus updateEmployee(@PathVariable(value = "employeeId") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws EmployeeException {
		try {
			Employee employee = employeeService.getEmployeeById(employeeId);
			if (employee == null)
				return HttpStatus.BAD_REQUEST;
			else {
				employee.setName(employeeDetails.getName());
				employee.setSalary(employeeDetails.getSalary());
				return employeeService.updateEmployee(employee) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
					"Error while Deleting employee : " + e.getLocalizedMessage());
		}
	}

	@DeleteMapping("/{employeeId}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "employeeId") Long employeeId)
			throws EmployeeException {
		Map<String, Boolean> response = new HashMap<>();
		try {
			Employee employee = employeeService.getEmployeeById(employeeId);

			if (employee != null) {
				employeeService.deleteEmployeeById(employeeId);
				response.put("Employee Record deleted...", Boolean.TRUE);
				return response;
			} else {
				response.put("Employee Record NOT Found...", Boolean.FALSE);
				return response;
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
					"Error while Deleting employee : " + e.getLocalizedMessage());
		}
	}

	// http://localhost:8082/api/employees/createEmp
	@PostMapping("/createEmp")
	ResponseEntity<String> createEmp(@RequestBody Employee employee)
			throws EmployeeException, EmployeeAlreadyExistsException {
		try {
			employee = employeeService.createEmp(employee);
			if (employee != null) {
			
			    HttpHeaders responseHeaders = new HttpHeaders();
			    responseHeaders.set("Create Employee ResponseHeader", "MyValue");
			    return new ResponseEntity<String>("Employee Object Added with unique Employee Id : " 
				+ employee.getEmployeeId(), responseHeaders, HttpStatus.CREATED);
				/*return ResponseEntity.status(HttpStatus.OK)
						.body("Employee Object Added with unique Employee Id : " 
								+ employee.getEmployeeId());*/
			} else {
				return ResponseEntity.badRequest().body("Employee Object is Null");
			}
		} catch (EmployeeException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
					"Error while creating employee : " + e.getLocalizedMessage());
		}
	}
//Controller Level Exception Handling
	@ExceptionHandler(value = Exception.class)
	public ResponseStatusException exceptionHandler(Exception e) {
		return new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"Error while processing employee services : " + e.getLocalizedMessage());

	}
}
