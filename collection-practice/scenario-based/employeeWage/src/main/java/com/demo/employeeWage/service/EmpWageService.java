package com.demo.employeeWage.service;

import java.util.Random;

import com.demo.employeeWage.interfaces.IEmpWageService;
import com.demo.employeeWage.model.CompanyEmpWage;
import com.demo.employeeWage.repository.CompanyRepository;

public class EmpWageService implements IEmpWageService {

    private CompanyRepository repo = new CompanyRepository();

    @Override
    public void addCompany(String name, int wagePerHour,
                           int maxDays, int maxHours) {
        repo.addCompany(new CompanyEmpWage(name, wagePerHour, maxDays, maxHours));
    }

    @Override
    public void computeWages() {
        for (CompanyEmpWage company : repo.getAllCompanies()) {
            computeCompanyWage(company);
        }
    }

    private void computeCompanyWage(CompanyEmpWage company) {

        int totalHours = 0, totalDays = 0, totalWage = 0;
        Random random = new Random();

        while (totalHours <= company.maxWorkingHours &&
               totalDays < company.maxWorkingDays) {

            totalDays++;

            int attendance = random.nextInt(3);
            int hours = switch (attendance) {
                case 1 -> 8;
                case 2 -> 4;
                default -> 0;
            };

            totalHours += hours;
            int dailyWage = hours * company.wagePerHour;
            totalWage += dailyWage;

            company.addDailyWage(dailyWage);
        }

        company.setTotalWage(totalWage);
    }

    @Override
    public int getTotalWage(String companyName) {
        CompanyEmpWage company = repo.findByName(companyName);
        return company != null ? company.totalWage : -1;
    }
}
