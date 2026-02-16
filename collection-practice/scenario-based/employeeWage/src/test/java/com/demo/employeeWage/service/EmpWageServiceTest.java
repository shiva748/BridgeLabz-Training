package com.demo.employeeWage.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpWageServiceTest {

    @Test
    void testAddCompany() {
        EmpWageService service = new EmpWageService();

        service.addCompany("TCS", 20, 20, 100);

        int wage = service.getTotalWage("TCS");

        // Wage not computed yet
        assertEquals(0, wage);
    }

    @Test
    void testComputeWages() {
        EmpWageService service = new EmpWageService();

        service.addCompany("TCS", 20, 20, 100);
        service.computeWages();

        int wage = service.getTotalWage("TCS");

        assertTrue(wage >= 0);
    }

    @Test
    void testMultipleCompanies() {
        EmpWageService service = new EmpWageService();

        service.addCompany("TCS", 20, 20, 100);
        service.addCompany("Infosys", 25, 22, 110);

        service.computeWages();

        assertTrue(service.getTotalWage("TCS") >= 0);
        assertTrue(service.getTotalWage("Infosys") >= 0);
    }

    @Test
    void testUnknownCompany() {
        EmpWageService service = new EmpWageService();

        service.addCompany("TCS", 20, 20, 100);
        service.computeWages();

        assertEquals(-1, service.getTotalWage("Google"));
    }
}