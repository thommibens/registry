package it.thommibens.poc.customer.controller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.thommibens.poc.customer.Customer;
import it.thommibens.poc.customer.manager.CustomerManager;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {
	
	@Autowired CustomerManager customerManager;
	
	@GetMapping({"", "search"})
	public List<Customer> get(){
		return customerManager.get();
	}
	
	@GetMapping("{id}")
	public Customer get(@PathVariable("id") String id){
		return customerManager.get(id);
	}

	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "search", params = {"name"})
	public List<Customer> searchName(@RequestParam String name){
		return filteredCustomer((customer) -> containsIgnoreCase(customer.getName(), name));
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "search", params = {"surname"})
	public List<Customer> searchSurname(@RequestParam String surname){
		return filteredCustomer((customer) -> containsIgnoreCase(customer.getSurname(), surname));
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "search", params = {"name", "surname"})
	public List<Customer> searchNameSurname(@RequestParam String name, @RequestParam String surname){
		return filteredCustomer((customer) -> containsIgnoreCase(customer.getName(), name),
				(customer) -> containsIgnoreCase(customer.getSurname(), surname));
	}
	
	
	private  List<Customer> filteredCustomer(Predicate<? super Customer>... filters) {
		Stream<Customer>  customers =  customerManager.get().parallelStream();
		for(Predicate<? super Customer> filter : filters) {
			customers = customers.filter(filter);
		}
		
		return customers.collect(Collectors.toList());
	}
	
	private boolean containsIgnoreCase(String string, String match) {
		return string.toUpperCase().contains(match.toUpperCase());
	}
}
