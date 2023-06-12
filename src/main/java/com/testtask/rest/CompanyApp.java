package com.testtask.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class CompanyApp extends Application {

    private Set <Class<?>> resources = new HashSet<>();

    public CompanyApp(){
        System.out.println("***********");
        resources.add(CompaniesController.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        System.out.println("***********");
        return resources;
    }
}
