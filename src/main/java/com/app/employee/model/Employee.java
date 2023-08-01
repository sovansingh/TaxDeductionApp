package com.app.employee.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empId")
	private int employeeId;
	
	@Column(name = "firstName")
	@NotBlank(message = "First Name must not be blank")
	private String firstName;
	
	@Column(name = "lastName")
	@NotBlank(message = "Last Name must not be blank")
	private String lastName;
	
	@Column(name = "email")
	@NotBlank(message = "Email ID must not be blank")
	private String email;
	
	@Column(name = "mobileNumber")
	@NotBlank(message = "Mobile Number must not be blank")
	private String mobileNumber;
	
	@Column(name = "dt")
    @NotNull(message = "Date of Joining must not be blank")
//    @JsonFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@Column(name = "salaryPerMonth")
	@Min(value = 10, message = "Salary must be greater than 10")
	private double salary;
	
//	@Column(name = "NumberOfMonth")
	@Transient
	private int numberOfMonth;

	public Employee(int employeeId, @NotBlank(message = "First Name must not be blank") String firstName,
			@NotBlank(message = "Last Name must not be blank") String lastName,
			@NotBlank(message = "Email ID must not be blank") String email,
			@NotBlank(message = "Mobile Number must not be blank") String mobileNumber,
			@NotNull(message = "Date of Joining must not be blank") LocalDate date,
			@Min(value = 10, message = "Salary must be greater than 10") double salary, int numberOfMonth) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.date = date;
		this.salary = salary;
		this.numberOfMonth = numberOfMonth;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getNumberOfMonth() {
		return numberOfMonth;
	}

	public void setNumberOfMonth(int numberOfMonth) {
		this.numberOfMonth = numberOfMonth;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobileNumber=" + mobileNumber + ", date=" + date + ", salary=" + salary
				+ ", numberOfMonth=" + numberOfMonth + "]";
	}

}
