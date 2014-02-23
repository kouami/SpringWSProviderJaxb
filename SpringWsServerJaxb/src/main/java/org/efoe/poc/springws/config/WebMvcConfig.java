/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.springws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Emmanuel
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "org.efoe")
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
       InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
       internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
       internalResourceViewResolver.setSuffix(".jsp");
       internalResourceViewResolver.setOrder(0);
        return internalResourceViewResolver;
    }

}
