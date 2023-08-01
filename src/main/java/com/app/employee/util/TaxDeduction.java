package com.app.employee.util;

import org.springframework.stereotype.Component;

@Component
public class TaxDeduction {

	public double calculateTax(double totalSalary) {
		double tax = 0;
		
		if(totalSalary <= 250000) {
			tax = 0;
		}else if (totalSalary <= 500000) {
			tax = (totalSalary-250000)*0.05;
		}else if(totalSalary <= 1000000){
			tax = 250000*0.05+(totalSalary - 500000)*0.1;
		}else if (totalSalary > 1000000) {
			tax = 250000*0.05+500000*0.1+(totalSalary - 1000000)*0.2;
		}
		
		return tax;
	}
}
