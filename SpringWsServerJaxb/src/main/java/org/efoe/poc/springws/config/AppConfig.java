/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.efoe.poc.springws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;
import org.springframework.ws.transport.http.WsdlDefinitionHandlerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

/**
 *
 * @author Emmanuel
 */
@Configuration
public class AppConfig {

    @Bean
    public Jaxb2Marshaller payloadMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(ClassUtils.getPackageName(org.efoe.poc.springws.model.ObjectFactory.class));
        marshaller.setSchemas(schemaResources());
        return marshaller;
    }

    @Bean
    public Wsdl11Definition customerServices() {
        //http://localhost:9080/csjb/services/customerServices.wsdl
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setRequestSuffix("Request");
        definition.setResponseSuffix("Response");
        definition.setSchemaCollection(schemaCollection());
        definition.setPortTypeName("CustomerService");
        definition.setLocationUri("/services");
        definition.setTargetNamespace("http://www.customer.com/service");
        return definition;
    }

    @Bean
    public XsdSchemaCollection schemaCollection() {
        CommonsXsdSchemaCollection collection = new CommonsXsdSchemaCollection();
        collection.setXsds(schemaResources());
        collection.setInline(true);
        return collection;
    }

    @Bean
    public Resource[] schemaResources() {
        return new ClassPathResource[]{new ClassPathResource("schemas/Customer.xsd")};
    }

    @Bean
    public WsdlDefinitionHandlerAdapter wsdlDefinitionHandlerAdapter() {
        WsdlDefinitionHandlerAdapter adapter = new WsdlDefinitionHandlerAdapter();
        adapter.setTransformLocations(true);
        return adapter;
    }

}
