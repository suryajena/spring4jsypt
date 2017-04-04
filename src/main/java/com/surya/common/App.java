package com.surya.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surya.customer.dao.CustomerDAO;
import com.surya.customer.model.Customer;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        Customer customer = new Customer(1, "Scottj",35);
        customerDAO.insert(customer);
    	
        Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println(customer1);
        
    }
}
