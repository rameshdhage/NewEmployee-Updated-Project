package com.springboot.demo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.demo.entity.Employee;
import com.springboot.demo.repository.EmployeeRepository;
import com.springboot.demo.serviceimpl.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl emServiceImpl;

	@Mock
	EmployeeRepository employeeRepository;

	@Test
	public void saveEmployeeTest() {

		Employee employee = new Employee(101, "Nayan Raut", "Pune", 20000);
		when(employeeRepository.save(employee)).thenReturn(employee);

		Employee actualEmp = emServiceImpl.saveEmployee(employee);

		assertEquals(employee, actualEmp);
	}

	@Test
	public void getAllEmployeeTest() {

		List<Employee> empList = new ArrayList();

		empList.add(new Employee(101, "Nayan", "Pune", 20000));
		empList.add(new Employee(105, "Rohan", "Delhi", 30000));
		empList.add(new Employee(102, "Akash", "Mumbai", 25000));

		when(employeeRepository.findAll()).thenReturn(empList);

		List<Employee> actualList = emServiceImpl.getAllEmployees();
		assertEquals(empList, actualList);

	}

	@Test
	public void getEmployeeByIdTest() {

		Employee employee1 = new Employee(101, "Nayan Raut", "Pune", 20000);
		Employee employee2 = new Employee(102, "Sejal Patni", "Delhi", 30000);

		when(employeeRepository.findByEmpId(101)).thenReturn(employee1);

		Employee actualEmp = emServiceImpl.getEmployeeById(101);

		assertEquals(employee1,actualEmp);
		
	}
	@Test
	public void getEmployeeByNameTest() {
		List<Employee>emplist=new ArrayList();
		emplist.add(new Employee(102,"ramesh","dilhi",49000));
		emplist.add(new Employee(103,"ganesh","mumbai",30000));
		emplist.add(new Employee(104,"shyam","nanded",39000));
		
		when(employeeRepository.getEmployeeByName("ramesh")).thenReturn(emplist);
		
		List<Employee> actualEmp=emServiceImpl.getEmployeeByname("ramesh");
		
		assertEquals(emplist,actualEmp);
		
	}
	
	

}
