package com.testtask.service;

import com.testtask.dao.CompanyDao;
import com.testtask.model.Company;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDaoServiceTest {


    private final CompanyDaoService companyDaoService = new CompanyDaoService();

    @Test
    public void testSelectAllCompanies() throws ClassNotFoundException {
        System.out.println(getClass().getResource("META-INF/persistence.xml"));
        List<Company> companyList = companyDaoService.selectAllCompanies();
        assertTrue(companyList.size() > 0);
    }

    @Test
    public void testGetCompanyById(){
        Company retrievedCompany = companyDaoService.getCompanyById("2");
        assertEquals("Коровья ферма", retrievedCompany.getName());
    }

}

