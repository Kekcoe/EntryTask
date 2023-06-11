package com.testtask.service;

import com.testtask.dao.CompanyDao;
import com.testtask.model.Company;
import com.testtask.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoService extends SessionUtil implements CompanyDao {
//    private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
//    private String jdbcUsername = "kekcoe";
//    private String jdbcPassword = "!!!QQQ222";

    private static final String SELECT_COMPANY_BY_ID = "select id,name,legalform,adress, branches from companies where id =?";

    private SessionFactory sessionFactory;

    public List<Company> selectAllCompanies() {
        openTransactionSession();
        String sql = "select * from companies";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Company.class);
        List<Company> companyList = query.list();
        closeTransactionSession();
        return companyList;
    }
}