/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.springws.services.impl;


import java.util.ArrayList;
import java.util.List;
import org.efoe.poc.springws.model.Address;
import org.efoe.poc.springws.model.Customer;
import org.efoe.poc.springws.model.CustomerResponse;
import org.efoe.poc.springws.services.CustomerService;
import org.springframework.stereotype.Component;

/**
 *
 * @author Emmanuel
 */
@Component("service")
public class CustomerServiceImpl implements CustomerService {

    private static List<Customer> customers = new ArrayList<Customer>();
    
    static {
        Customer c0 = new Customer();
        c0.setFirstName("Efoe");
        c0.setLastName("Akolly");
        c0.setSsn("111111111");
        
        Address a0 = new Address();
        a0.setStreet("193 rd Street West");
        a0.setCity("Farmington");
        a0.setState("MN");
        c0.setAddress(a0);
        
        Customer c1 = new Customer();
        c1.setFirstName("Emmanuel");
        c1.setLastName("Akolly");
        c1.setSsn("222222222");
        
        Address a1 = new Address();
        a1.setStreet("203 rd Street East");
        a1.setCity("Farmington");
        a1.setState("MN");
        c1.setAddress(a1);
        
        customers.add(c0);
        customers.add(c1); 
    }
    
    @Override
    public CustomerResponse getCustomer(String ssn) {
        Customer c = null;
        CustomerResponse resp = new CustomerResponse();
        
        for(int i = 0; i < customers.size(); i ++){
            if(customers.get(i).getSsn().equals(ssn)){
                c = customers.get(i);
                resp.setFirstName(c.getFirstName());
                resp.setLastName(c.getLastName());
                resp.setSsn(c.getSsn());
                CustomerResponse.Address addr = new CustomerResponse.Address();
                addr.setCity(c.getAddress().getCity());
                addr.setState(c.getAddress().getState());
                addr.setStreet(c.getAddress().getStreet());
                resp.setAddress(addr);
                System.out.println("FOUND:::::::::::::::::::::::::::::::");
                break;
            }
        }
        
        return resp;
    }
    
}
