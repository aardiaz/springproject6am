package com.bway.springdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.bway.springdemo.model.Employee;
import com.bway.springdemo.repository.EmployeeRepository;
import com.bway.springdemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void addEmp(Employee employee) {
		 
		empRepo.save(employee);
	}

	@Override
	public void deleteEmp(Long id) {
		 empRepo.deleteById(id);
	}

	@Override
	public void updateEmp(Employee employee) {
		
		empRepo.save(employee);
	}

	@Override
	public Employee getEmpById(Long id) {
		 
		return empRepo.getById(id);
	}

	@Override
	public List<Employee> getAllEmps() {
		
		return empRepo.findAll();
	}
	
	
}
