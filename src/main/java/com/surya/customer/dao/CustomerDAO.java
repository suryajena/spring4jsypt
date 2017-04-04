package com.surya.customer.dao;

import com.surya.customer.model.Customer;

public interface CustomerDAO 
{
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}




