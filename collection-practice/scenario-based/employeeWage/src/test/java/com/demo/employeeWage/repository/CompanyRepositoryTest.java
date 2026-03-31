package com.demo.employeeWage.repository;

import org.junit.jupiter.api.Test;

import com.demo.employeeWage.model.CompanyEmpWage;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyRepositoryTest {

    @Test
    void testAddCompany() {
        CompanyRepository repo = new CompanyRepository();

        CompanyEmpWage company = new CompanyEmpWage("TCS", 20, 20, 100);
        repo.addCompany(company);

        assertEquals(1, repo.getAllCompanies().size());
    }

    @Test
    void testFindByName() {
        CompanyRepository repo = new CompanyRepository();

        repo.addCompany(new CompanyEmpWage("TCS", 20, 20, 100));

        CompanyEmpWage result = repo.findByName("TCS");

        assertNotNull(result);
        assertEquals("TCS", result.companyName);
    }

    @Test
    void testFindByNameNotFound() {
        CompanyRepository repo = new CompanyRepository();

        CompanyEmpWage result = repo.findByName("Google");

        assertNull(result);
    }
}