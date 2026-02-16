package com.demo.employeeWage;

import com.demo.employeeWage.service.EmpWageService;

public class App 
{
	public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation");

        EmpWageService service = new EmpWageService();

        service.addCompany("TCS", 20, 20, 100);
        service.addCompany("Infosys", 25, 22, 110);
        service.addCompany("Wipro", 18, 20, 90);

        service.computeWages();

        System.out.println("TCS Wage = " + service.getTotalWage("TCS"));
        System.out.println("Infosys Wage = "+ service.getTotalWage("Infosys"));
    }
}
