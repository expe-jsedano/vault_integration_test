package com.expedia.e3.shop.poc.vault.integration;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainClass {
    
    private static final Logger LOG = Logger.getLogger(MainClass.class);

    public static void main(String []args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("vaultContext.xml");
        Map <String, String> vaultMap = (Map<String, String>) context.getBean("vaultMap");    
        LOG.info(vaultMap);

    }
}
