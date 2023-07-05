package com.greatlearning.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ems.model.Employee;
import com.greatlearning.ems.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		return this.emprepo.save(employee);
	}

	@Override
	public List<Employee> showAllEmployees() {
		List<Employee> employee = emprepo.findAll();
		return employee;
	}

	@Override
	public Employee findEmployeeById(int id) {
		Optional<Employee> optionalEmployee = this.emprepo.findById(id);

		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		throw new IllegalArgumentException("Invalid id passed");
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> updateEmployee = this.emprepo.findById(id);
		if(updateEmployee.isPresent()) {
			Employee emptemp = updateEmployee.get();
			emptemp.setFirstName(employee.getFirstName());
			emptemp.setLastName(employee.getLastName());
			emptemp.setEmail(employee.getEmail());
			emprepo.save(emptemp);
			return employee;
		}
		throw new IllegalArgumentException("Invalid id passed");
	}

	@Override
	public void deleteEmployee(int id) {
		this.emprepo.deleteById(id);

	}

}
