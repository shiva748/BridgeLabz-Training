package com.demo.employeeWage.repository;

import java.util.ArrayList;

import com.demo.employeeWage.model.CompanyEmpWage;

public class CompanyRepository {

    private ArrayList<CompanyEmpWage> companies = new ArrayList<>();

    public void addCompany(CompanyEmpWage company) {
        companies.add(company);
    }

    public ArrayList<CompanyEmpWage> getAllCompanies() {
        return companies;
    }

    public CompanyEmpWage findByName(String name) {
        for (CompanyEmpWage c : companies) {
            if (c.companyName.equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
}
