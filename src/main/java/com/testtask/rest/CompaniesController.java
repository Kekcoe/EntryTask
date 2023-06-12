package com.testtask.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class CompaniesController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHello(){
        System.out.println("-----------------");
        return Response.ok("OK").build();
    }
}
