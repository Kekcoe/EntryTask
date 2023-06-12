package com.testtask.rest;


import com.testtask.dao.CompanyDao;
import com.testtask.model.Company;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class CompaniesController {

    @Inject
    CompanyDao companyDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getHello(){
        System.out.println("-----------------");
        return companyDao.selectAllCompanies();
    }
}
