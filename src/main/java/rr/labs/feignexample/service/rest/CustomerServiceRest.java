package rr.labs.feignexample.service.rest;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rr.labs.feignexample.domain.Customer;
import rr.labs.feignexample.repository.CustomerRepository;

/**
 * Customer service
 * 
 * @author regis.rocha
 *
 */
@RestController("/customer")
public class CustomerServiceRest {
	
	/**
	 * LOG
	 */
	private Logger LOG = Logger.getLogger(CustomerServiceRest.class.getName());
	
	/**
	 * @Inject
	 */
	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * Add new customer
	 * 
	 * @param customer - Customer
	 * 
	 * @return ResponseEntity<Customer>
	 */
	@PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		LOG.log(Level.INFO, "Adding new customer: " + customer);
		return ResponseEntity.ok(customerRepository.create(customer));
	}
	
	
	/**
	 * Find customer
	 * 
	 * @param id - String
	 * 
	 * @return ResponseEntity<Customer>
	 */
	@GetMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> get(@PathVariable(name = "id") String id) {
		LOG.log(Level.INFO, "finding customer: " + id);
		return ResponseEntity.ok(customerRepository.get(id));
	}
	
	
	/**
	 * Delete customer
	 * 
	 * @param id - String
	 * 
	 * @return ResponseEntity<Customer>
	 */
	@DeleteMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> delete(@PathVariable(name = "id") String id) {
		LOG.log(Level.INFO, "deleting customer: " + id);
		customerRepository.delete(id);
		return ResponseEntity.ok("");
	}
	
	
	/**
	 * Update customer
	 * 
	 * @param customer - Customer
	 * 
	 * @return ResponseEntity<Customer>
	 */
	@PutMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> update(@RequestBody Customer customer) {
		LOG.log(Level.INFO, "updating customer: " + customer);
		customerRepository.update(customer);
		return ResponseEntity.ok("");
	}

}
