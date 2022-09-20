package com.bway.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springdemo.model.Employee;
import com.bway.springdemo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employee")
	public String getForm() {
		
		return "EmployeeForm";
	}
	
	@PostMapping("/employee")
	public String saveEmpData(@ModelAttribute Employee emp) {
		
		service.addEmp(emp);
		
		return "EmployeeForm";
	}
	
	@GetMapping("/list")
	public String empList(Model model) {
		
		model.addAttribute("empList", service.getAllEmps());
		
		return "EmployeeList";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long empid) {
		
		service.deleteEmp(empid);
		
		return "redirect:/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		
		model.addAttribute("emodel", service.getEmpById(id));
		
		return "EditForm";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Employee employee) {
		
		service.updateEmp(employee);
		return "redirect:/list";
	}
	

}
