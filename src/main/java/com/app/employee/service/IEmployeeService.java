package com.app.employee.service;

import java.util.List;

import com.app.employee.model.Employee;

public interface IEmployeeService {

	public Employee AddEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
}
