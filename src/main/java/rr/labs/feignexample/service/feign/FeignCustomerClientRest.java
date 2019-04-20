package rr.labs.feignexample.service.feign;

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
import rr.labs.feignexample.service.client.CustomerServiceClient;

/**
 * Realiza as devidas chamadas para API REST customer utilizando Feign
 * 
 * @author regis.rocha
 *
 */
@RestController(value = "client-customer")
public class FeignCustomerClientRest {
	
	/**
	 * LOG
	 */
	private Logger LOG = Logger.getLogger(FeignCustomerClientRest.class.getName());
	
	/**
	 * @Inject
	 */
	@Autowired
	private CustomerServiceClient customerServiceClient;
	
	/**
	 * Client - Add new customer
	 * 
	 * @param customer - Customer
	 * 
	 * @return ResponseEntity<Customer>
	 */
	@PostMapping(value = "/client-customer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		LOG.log(Level.INFO, "Client - Adding new customer: " + customer);
		return customerServiceClient.create(customer);
	}
	
	
	/**
	 * Client - Find customer
	 * 
	 * @param id - String
	 * 
	 * @return ResponseEntity<Customer>
	 */
	@GetMapping(value = "/client-customer/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> get(@PathVariable(name = "id") String id) {
		LOG.log(Level.INFO, "Client - finding customer: " + id);
		return customerServiceClient.get(id);
	}
	
	
	/**
	 * Client - Delete customer
	 * 
	 * @param id - String
	 * 
	 * @return ResponseEntity<Customer>
	 */
	@DeleteMapping(value = "/client-customer/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> delete(@PathVariable(name = "id") String id) {
		LOG.log(Level.INFO, "Client - deleting customer: " + id);
		customerServiceClient.delete(id);
		return ResponseEntity.ok("");
	}
	
	
	/**
	 * Client - Update customer
	 * 
	 * @param customer - Customer
	 * 
	 * @return ResponseEntity<Customer>
	 */
	@PutMapping(value = "/client-customer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> update(@RequestBody Customer customer) {
		LOG.log(Level.INFO, "Client - updating customer: " + customer);
		customerServiceClient.update(customer);
		return ResponseEntity.ok("");
	}
}
