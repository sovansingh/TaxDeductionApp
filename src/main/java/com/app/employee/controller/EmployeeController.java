package com.app.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.employee.model.Employee;
import com.app.employee.model.EmployeeResponse;
import com.app.employee.service.impl.EmployeeServiceImpl;
import com.app.employee.util.TaxDeduction;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {


	@Autowired
	private EmployeeServiceImpl employeeService;

	@Autowired
	private TaxDeduction taxDeduction;

	@PostMapping(value = "/add")
	public ResponseEntity<String> addEmployee(@RequestBody @Valid Employee employee) {
		Employee emp =  employeeService.AddEmployee(employee);
		String str = null;
		if (emp.getEmployeeId() > 0) {
			str = "Employee with id: " + emp.getEmployeeId() + "successfully";
		}
		return new ResponseEntity<>(str, HttpStatus.CREATED);
	}

	@GetMapping("/tax")
	public ResponseEntity<List<EmployeeResponse>> getemployeeTax() {
		List<Employee> employees = employeeService.getAllEmployees();
		List<EmployeeResponse> responses = new ArrayList<>();

		for (Employee employee : employees) {
			double totalSalary = employee.getSalary() * employee.getNumberOfMonth();
			double tax = taxDeduction.calculateTax(totalSalary);
			double cess = (totalSalary > 2500000) ? (totalSalary - 2500000) * 0.02 : 0;
			responses.add(new EmployeeResponse(employee.getEmployeeId(), employee.getFirstName(),
					employee.getLastName(), totalSalary, tax, cess));
		}

		return new ResponseEntity<List<EmployeeResponse>>(responses, HttpStatus.OK);
	}

}
