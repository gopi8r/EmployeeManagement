package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public Employee createEmployee(Employee employee) {
		return employeeDao.save(employee);
		
	}
	
	public Employee getEmployeeById(int id) {
		return employeeDao.findById(id).orElse(null);
	}
	
	public String deleteEmployeeById(int id) {
		employeeDao.deleteById(id);
		return "User got deleted";
	}
	
	 public List<Employee> getUsers(){
			return employeeDao.findAll();
		}

	
	public Employee updateEmployee(Employee employee) {
		Employee oldUser=null;
		Optional<Employee> optionalemployee=employeeDao.findById(employee.getId());
		if(optionalemployee.isPresent()) {
			oldUser=optionalemployee.get();
			oldUser.setName(employee.getName());
			oldUser.setSkill(employee.getSkill());
			employeeDao.save(oldUser);
		}else {
			return new Employee();
		}
		return oldUser;
	}
	
	public List<Employee> getEmployeeBySkill(String skill){
		return employeeDao.findBySkill(skill);
	}

}
