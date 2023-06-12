package com.testtask.service;

import com.testtask.model.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDaoServiceTest {

    private final CompanyDaoService companyDaoService = new CompanyDaoService();

    @Test
    public void testSelectAllCompanies() {
        List<Company> companyList = companyDaoService.selectAllCompanies();
        assertTrue(companyList.size() > 0);
    }

    @Test
    public void testGetCompanyById(){
        Company retrievedCompany = companyDaoService.getCompanyById("2");
        assertEquals("Коровья ферма", retrievedCompany.getName());
    }

}

