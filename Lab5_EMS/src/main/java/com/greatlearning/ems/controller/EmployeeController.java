package com.greatlearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ems.model.Employee;
import com.greatlearning.ems.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	public EmployeeController(EmployeeService employeeservice) {
		this.service = employeeservice;
	}
	
	@GetMapping("/list")
	public String listBooks(Model model) {
		List<Employee> employees = this.service.showAllEmployees();
		model.addAttribute("employee", employees);
		return "employee/list-employees";
	}

	@PostMapping("/save")
	public String saveBook(@ModelAttribute("employee") Employee employee) {
		this.service.saveEmployee(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model model) {

		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employee/employee-form";
	}

	@PostMapping("/delete")
	public String deleteBook(@RequestParam("id") int id) {
		this.service.deleteEmployee(id);
		return "redirect:/employees/list";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {

		
		Employee theemployee = service.findEmployeeById(id);

	
		model.addAttribute("employee", theemployee);

		return "employee/employee-form";
	}
}
