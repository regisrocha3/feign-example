package rr.labs.feignexample.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rr.labs.feignexample.domain.Customer;

/**
 * Client REST Customer Service
 * 
 * @author regis.rocha
 *
 */
@FeignClient(name = "customer-services", url = "${feign.client.url}")
public interface CustomerServiceClient {

	@PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Customer> create(@RequestBody Customer customer);
	
	@GetMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Customer> get(@PathVariable(name = "id") String id);
	
	@DeleteMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<String> delete(@PathVariable(name = "id") String id);
	
	@PutMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<String> update(@RequestBody Customer customer);
}
