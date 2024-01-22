package io.matheusvictor.controller;

import io.matheusvictor.domain.Customer;
import io.matheusvictor.service.CustomerService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/api/v1/customers")
public class CostumerResource {

    @Inject
    CustomerService customerService;

    @GET
    @RolesAllowed("manager")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Customer> customer = new ArrayList<>();
        try {
            customer = customerService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(customer).build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("manager")
    public Response create(Customer customer) {
        try {
            customerService.create(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(customer).build();
    }
}
