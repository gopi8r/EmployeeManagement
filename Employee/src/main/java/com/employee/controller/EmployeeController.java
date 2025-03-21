package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value="/add")
	public Employee createEmployee(@RequestBody   Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping(value="/emp/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping(value= "/emp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployeeById(id);
	}
	
	@GetMapping(value= "/employees")
	public List<Employee> getAllUsers() {
		return employeeService.getUsers();
	}
	
	@PutMapping(value= "/updateemployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@GetMapping("/skill/{skill}")
	public List<Employee> getEmployeesBySkill(@PathVariable String skill){
		return employeeService.getEmployeeBySkill(skill);
	}


}
