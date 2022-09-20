package com.bway.springdemo.service;

import java.util.List;

import com.bway.springdemo.model.Employee;

public interface EmployeeService {

	void addEmp(Employee employee);

	void deleteEmp(Long id);

	void updateEmp(Employee employee);

	Employee getEmpById(Long id);

	List<Employee> getAllEmps();
}
