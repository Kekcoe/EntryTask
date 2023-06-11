package com.testtask.dao;

import com.testtask.model.Company;

import java.util.List;

public interface CompanyDao {
    public List<Company> selectAllCompanies();
}
