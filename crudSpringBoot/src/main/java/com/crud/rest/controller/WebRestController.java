package com.crud.rest.controller;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.model.Customer;

 
@RestController
@RequestMapping(value="/restApi")
public class WebRestController {

	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>(){

		{
	        put(100, new Customer(100, "FirstName1", "LastName1", "123-510-650"));
	        put(200, new Customer(200, "FirstName2", "LastName2", "123-408-650"));
	        put(300, new Customer(300, "FirstName3", "LastName3", "123-408-510"));
	    }
	};
	
	@GetMapping(value="/customer")
	public List<Customer> getAll(){
		List<Customer> results = customers.entrySet().stream()
									.map(entry ->entry.getValue())
									.collect(Collectors.toList());
		return results;
	}
	
	@GetMapping(value="/customer/{id}")
	public Customer getCustomer(@PathVariable int id){
		return customers.get(id);
	}
	
	@PostMapping(value="/customer")
	public Customer postCustomer(@RequestBody Customer customer){
		int id = findMaxKey() + 100;
		customer.setId(id);
		customers.put(id, customer);
		return customer;
	}
	
	private int findMaxKey() {
	 	return Collections.max(customers.keySet());
	}
	
	@PutMapping(value="/customer/{id}")
	public void putCustomer(@RequestBody Customer customer, @PathVariable int id){
		customers.replace(id, customer);
	}
	
	@DeleteMapping(value="/customer/{id}")
	public void deleteCustomer(@PathVariable int id){
		customers.remove(id);
	}
}