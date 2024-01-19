package com.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	
	public Employee findByEmpId(Integer id);
	
	
	@Query(value="select * from employee where emp_name=? order by salary desc" , nativeQuery =true)
	public List<Employee> getEmployeeByName(String empName);
	
	public List<Employee> getEmployeeByempCity(String empCity);
	
	


	

	
}
