/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.springws.services;

import org.efoe.poc.springws.model.CustomerResponse;




/**
 *
 * @author Emmanuel
 */
public interface CustomerService {
    
    public CustomerResponse getCustomer(String ssn);
    
}
