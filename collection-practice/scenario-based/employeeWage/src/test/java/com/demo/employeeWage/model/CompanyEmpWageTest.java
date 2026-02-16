package com.demo.employeeWage.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompanyEmpWageTest {

    @Test
    void testConstructor() {
        CompanyEmpWage company = new CompanyEmpWage("TCS", 20, 20, 100);

        assertEquals("TCS", company.companyName);
        assertEquals(20, company.wagePerHour);
        assertEquals(20, company.maxWorkingDays);
        assertEquals(100, company.maxWorkingHours);
        assertTrue(company.dailyWages.isEmpty());
    }

    @Test
    void testAddDailyWage() {
        CompanyEmpWage company = new CompanyEmpWage("TCS", 20, 20, 100);

        company.addDailyWage(160);
        company.addDailyWage(80);

        assertEquals(2, company.dailyWages.size());
        assertEquals(160, company.dailyWages.get(0));
    }

    @Test
    void testSetTotalWage() {
        CompanyEmpWage company = new CompanyEmpWage("TCS", 20, 20, 100);

        company.setTotalWage(2000);

        assertEquals(2000, company.totalWage);
    }
}
