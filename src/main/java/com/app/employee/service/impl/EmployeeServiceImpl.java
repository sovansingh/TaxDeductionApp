package com.app.employee.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.employee.model.Employee;
import com.app.employee.repository.EmployeeRepository;
import com.app.employee.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		LocalDate d = null;
		for (Employee emp : employees) {
			if (emp != null) {
				d = emp.getDate();
			}
			Period period = Period.between(d, LocalDate.now());
			int totalMonths = period.getYears() * 12 + period.getMonths();
//			int days = period.getDays();
//			System.out.println(days);
			emp.setNumberOfMonth(totalMonths);
		}
		return employees;
	}

	@Override
	public Employee AddEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

}
