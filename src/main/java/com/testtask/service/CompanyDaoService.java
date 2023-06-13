package com.testtask.service;

import com.testtask.dao.CompanyDao;
import com.testtask.model.Company;
import com.testtask.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;


import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Logger;


@Named
public class CompanyDaoService extends SessionUtil implements CompanyDao {
    private static final Logger log = Logger.getLogger(CompanyDaoService.class.getName());

    public CompanyDaoService() {
    }

    public Company getCompanyById(String id) {
        openTransactionSession();
        String sql = "select * from companies where id = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Company.class);
        query.setParameter("id",id);
        return (Company)query.getSingleResult();
    }

    public List<Company> selectAllCompanies() {
        log.info("******** selectAllCompanies*******");
        openTransactionSession();
        String sql = "select * from companies";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Company.class);
        List<Company> companyList = query.list();
        String arrayListAsString = companyList.toString();
        log.info(arrayListAsString);
        closeTransactionSession();
        return companyList;
    }
}