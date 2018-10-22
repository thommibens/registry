package it.thommibens.poc.customer.manager;

import java.util.List;

import it.thommibens.poc.customer.Customer;

public interface CustomerManager {
	
	public Customer get(String id);
	public List<Customer> get();
	
}
