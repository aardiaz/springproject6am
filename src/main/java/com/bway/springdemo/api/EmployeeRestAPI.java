package com.bway.springdemo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.springdemo.model.Employee;
import com.bway.springdemo.service.EmployeeService;

@RestController
@RequestMapping("/emp/api")
public class EmployeeRestAPI {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/list")
	 public List<Employee> getAll() {
		
		 return service.getAllEmps();
	 }
	
	@PostMapping("/add")
	public String add(@RequestBody Employee emp) {
		
		service.addEmp(emp);
		
		return "added success";
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Employee emp) {
		
		service.updateEmp(emp);
		
		return "update success";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		
		service.deleteEmp(id);
		
		return "delete success";
	}
	
	@GetMapping("/{id}")
	public Employee getOne(@PathVariable Long id) {
		
		return service.getEmpById(id);
	}
	
	
	@GetMapping("/json2obj")
	public String jsonToObject() {
		
		RestTemplate  tmp = new RestTemplate();
		Employee emp = tmp.getForObject("http://localhost/emp/api/4", Employee.class);
		
		return emp.getFname() +" "+  emp.getLname();
	}
	
	@GetMapping("/jsonArray")
	public String jsonArrayToObjArray() {
		
		RestTemplate  temp = new RestTemplate();
		Employee[]  emps = temp.getForObject("http://localhost/emp/api/list", Employee[].class);
		
		return "first Name = "+emps[2].getFname();
	}
	
}
