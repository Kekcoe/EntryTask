package com.testtask.service;

import com.testtask.dao.CompanyDao;
import com.testtask.model.Company;
import com.testtask.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CompanyDaoService extends SessionUtil implements CompanyDao {

    public Company getCompanyById(String id) {
        openTransactionSession();
        String sql = "select * from companies where id = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Company.class);
        query.setParameter("id",id);
        return (Company)query.getSingleResult();
    }

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