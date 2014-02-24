/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.springws.services.endpoints;

import javax.annotation.Resource;
import org.efoe.poc.springws.model.CustomerRequest;
import org.efoe.poc.springws.model.CustomerResponse;
import org.efoe.poc.springws.services.CustomerService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author Emmanuel
 */
@Endpoint
public class CustomerServiceEndpoint {
    
    private static final String NAMESPACE_URI = "http://www.customer.com/service";
    private static final String LOCAL_PART = "CustomerRequest";
    
    @Resource(name="service")
    private CustomerService service;
    
    @PayloadRoot(localPart=LOCAL_PART, namespace = NAMESPACE_URI)
    @ResponsePayload
    public CustomerResponse getCustomer(@RequestPayload CustomerRequest request) {
        System.out.println("ENDPOINT:::::::::::::::::::::");
        return service.getCustomer(request.getSsn());
    }
}
