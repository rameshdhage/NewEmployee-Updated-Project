package com.springboot.demo.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.entity.Employee;
import com.springboot.demo.repository.EmployeeRepository;
import com.springboot.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logs =LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	
	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployee(Employee employee) {
		logs.info("Inside a saveEmployee method of Service class>>" +employee);
		return repository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		logs.info("Inside a getEmployeeById method of Service class>>" +id);
		Employee emp = repository.findByEmpId(id);
		
		logs.info("repo call is completed>>" +emp);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = (List<Employee>) repository.findAll();
		return empList;
	}


	@Override
	public List<Employee> getEmployeeByname(String name) {
		
		List<Employee> empList = repository.getEmployeeByName(name);
		 return empList;
	}

	@Override
	public String deleteEmp(int id) {
		repository.deleteById(id);
		return "employee delete successfully";
	}

	@Override
	public List<Employee> getEmployeeBycity(String empCity) {
	List <Employee>	emplist=repository.getEmployeeByempCity(empCity);
		return emplist;
	}

	@Override
	public List<Employee> getEmployeeBysalary(Integer salary) {
     List<Employee> emplist= repository.getEmployeeByempSalary(salary);
		return emplist;
	}

	
	

}
