package com.demo.employeeWage.model;


import java.util.ArrayList;

public class CompanyEmpWage {

    public String companyName;
    public int wagePerHour;
    public int maxWorkingDays;
    public int maxWorkingHours;
    public int totalWage;
    public ArrayList<Integer> dailyWages = new ArrayList<>();

    public CompanyEmpWage(String companyName, int wagePerHour,
                          int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
    }

    public void addDailyWage(int wage) {
        dailyWages.add(wage);
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }
}