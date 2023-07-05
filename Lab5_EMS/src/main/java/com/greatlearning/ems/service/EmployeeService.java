package com.greatlearning.ems.service;

import java.util.List;

import com.greatlearning.ems.model.Employee;

public interface EmployeeService {

	 Employee saveEmployee(Employee employee);
	 List<Employee> showAllEmployees();
	 Employee findEmployeeById(int id);
	 Employee updateEmployee(int id, Employee employee);
	 void deleteEmployee(int id);
}
