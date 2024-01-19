package com.springboot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.Employee;
import com.springboot.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private static final Logger logs =  LoggerFactory.getLogger(EmployeeController.class);
	

	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		 logs.info("In saveEmployee API>>" +employee);
		Employee emp = employeeService.saveEmployee(employee);
		logs.info("After completing the service call>>" +emp);
		return ResponseEntity.ok().body(emp);
	}

	@GetMapping("/getEmpById/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		
		logs.info("Inside a getEmployeeById method of Controller>>" +id );
		Employee emp = employeeService.getEmployeeById(id);
		logs.info("Service call completed>>" +emp );

		return emp;
	}

	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployees() {
		List<Employee> empList = employeeService.getAllEmployees();
		return empList;
	}
	
	
	
	@GetMapping("/getEmpByName/{name}")
	public List<Employee> getEmployeesByName(@PathVariable String name){
		 List<Employee> empList=employeeService.getEmployeeByname(name);
		 return empList;
	}
	
	
	@GetMapping("/getEmpByCity/{empCity}")
	public List<Employee> getEmployeeByCity(@PathVariable String empCity){
		
	List<Employee>	emplist=employeeService.getEmployeeBycity(empCity);
		return emplist;
	}
	
	
	
	
	@DeleteMapping("deleteEmp/{id}")
	public void deleteEmp(@PathVariable int id) {
		employeeService.deleteEmp(id);
	}

}
