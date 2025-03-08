package com.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	@Query(value = "SELECT * FROM emptable WHERE skill = ?1", nativeQuery = true)
	List<Employee> findBySkill(String skill);

}
