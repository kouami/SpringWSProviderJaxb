/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.springws.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.efoe.poc.springws.config.WebMvcConfig;
import org.springframework.ws.transport.http.MessageDispatcherServlet;



/**
 *
 * @author Emmanuel
 */
public class WebXml implements WebApplicationInitializer {
    
    private static final String CONFIG_LOCATION = "org.efoe.poc.config";
    private static final String MAPPING_URL = "*.htm";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(MAPPING_URL);
        
         ServletRegistration.Dynamic ws = servletContext.addServlet("MessageDispatcherServlet", new MessageDispatcherServlet(context));
         ws.setInitParameter("transformWsdlLocations", "true");
         ws.addMapping("/services/*");
    }
    
    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        context.register(WebMvcConfig.class);
        return context;
    }
    
}
