package com.demo.employeeWage.interfaces;

public interface IEmpWageService {

    void addCompany(String name, int wagePerHour,
                    int maxDays, int maxHours);

    void computeWages();

    int getTotalWage(String companyName);
}
