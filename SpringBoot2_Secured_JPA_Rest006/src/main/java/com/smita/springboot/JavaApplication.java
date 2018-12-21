/**
 * 
 */
package com.smita.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smita.springboot.entities.Employee;
import com.smita.springboot.service.IEmployeeService;

/**
 * @author brije
 *
 */
//for stand-alone java application
//@SpringBootApplication
public class JavaApplication implements CommandLineRunner{
    @Autowired
    IEmployeeService employeeService;
    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }
    @Override
    public void run(String... arg0) throws Exception {
        employeeService.addEmployee(new Employee("Zara", 7890.99));
        List<Employee> employees = employeeService.getEmployeeList();
        for(Employee employee : employees)
        {
            System.out.println("Introducing  => " + employee);
        }
    }
}