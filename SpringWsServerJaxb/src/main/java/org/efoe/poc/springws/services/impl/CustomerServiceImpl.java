/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.springws.services.impl;


import org.efoe.poc.springws.model.CustomerResponse;
import org.efoe.poc.springws.services.CustomerService;
import org.springframework.stereotype.Component;

/**
 *
 * @author Emmanuel
 */
@Component("service")
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerResponse getCustomer(String ssn) {
        return null;
    }
    
}
