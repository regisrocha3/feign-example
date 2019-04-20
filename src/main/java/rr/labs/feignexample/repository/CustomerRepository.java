package rr.labs.feignexample.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import rr.labs.feignexample.domain.Customer;

/**
 * Customer repository
 * 
 * @author regis.rocha
 *
 */
@Service
@Scope("singleton")
public class CustomerRepository {
	
	/**
	 * Customer DB
	 */
	private Map<String, Customer> customers = new HashMap<String, Customer>();

	/**
	 * Persist new customer
	 * 
	 * @param customer - Customer
	 * 
	 * @return Customer
	 */
	public Customer create(final Customer customer) {
		customer.setId(UUID.randomUUID().toString());
		customers.put(customer.getId(), customer);
		
		return customer;
	}
	
	/**
	 * Delete customer
	 * 
	 * @param id - String
	 * 
	 */
	public void delete(final String id) {
		customers.remove(id);
	}
	
	/**
	 * Update customer
	 * 
	 * @param customer - Customer
	 * 
	 * @return Customer
	 */
	public Customer update(final Customer customer) {
		customers.put(customer.getId(), customer);
		return customer;
	}
	
	/**
	 * Find customer
	 * 
	 * @param id - String
	 * 
	 * @return Customer
	 */
	public Customer get(final String id) {
		return customers.get(id);
	}

}
