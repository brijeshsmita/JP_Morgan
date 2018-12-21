package com.smita.springboot.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smita.springboot.entities.Employee;
import com.smita.springboot.exception.EmployeeException;
import com.smita.springboot.service.IEmployeeService;
/** @author Smita **/
/*This @CrossOrigin annotation enables cross-origin requests only for controller or the specific method. By default, its allows all origins, all headers, the HTTP methods specified in the @RequestMapping annotation and a maxAge of 30 minutes is used. You can customize this behavior by specifying the value of one of the annotation attributes: origins, methods, allowedHeaders, exposedHeaders, allowCredentials or maxAge. In this example, we only allow http://localhost:8082 to send cross-origin requests.*/
//prep-work 1> @CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//prep-work 2> @RestController
@RestController
//prep-work 3> @RequestMapping
@RequestMapping("/api/employees")
public class EmployeeController {
	//prep-work 4> @Autowired IEmployeeService
	@Autowired private IEmployeeService employeeService;
	
	@GetMapping(value="",produces="application/json")
	public List<Employee> getAll() throws EmployeeException{
			return employeeService.getEmployeeList();
	}
	@GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "employeeId") Long employeeId) throws EmployeeException{
		System.out.println("EmployeeController -> find : "+employeeId);
		Employee employee =employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok().body(employee);
	}
	@PostMapping("/save")
    public HttpStatus  saveEmployee(@RequestBody Employee employee) throws EmployeeException {
		return employeeService.addEmployee(employee) != null? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }
	@PutMapping("/{employeeId}")
    public HttpStatus updateEmployee(@PathVariable(value = "employeeId") Long employeeId,
         @Valid @RequestBody Employee employeeDetails) throws EmployeeException  {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(employee==null)
        	return HttpStatus.BAD_REQUEST;
        else {
        employee.setName(employeeDetails.getName());
        employee.setSalary(employeeDetails.getSalary());
        return employeeService.updateEmployee(employee)? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
        }         
    }
	@DeleteMapping("/{employeeId}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "employeeId") Long employeeId) throws EmployeeException{
		 Employee employee = employeeService.getEmployeeById(employeeId);
		 Map<String, Boolean> response = new HashMap<>();
	        if(employee!=null) {
	        	employeeService.deleteEmployeeById(employeeId);
	        	
	            response.put("deleted", Boolean.TRUE);
	        }        
        return response;
    }
}
