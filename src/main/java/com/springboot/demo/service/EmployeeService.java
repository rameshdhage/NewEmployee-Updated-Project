package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.entity.Employee;

public interface EmployeeService {
	
	
	public Employee saveEmployee(Employee employee);
	
	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployees();
	
	
	
	public List<Employee> getEmployeeByname(String empName);
	
	public List<Employee> getEmployeeBycity(String empCity);
	
	
	
	public String deleteEmp(int id);
	
	}
