package rr.labs.feignexample.service.ws;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rr.labs.feignexample.service.client.RandomServiceClient;

/**
 * Realiza a chamada de uma API REST utilizando Feign
 * 
 * @author regis.rocha
 *
 */
@RestController
public class FeignServiceRest {
	
	/**
	 * LOG
	 */
	private Logger LOG = Logger.getLogger(FeignServiceRest.class.getName());
	
	/**
	 * @Inject
	 */
	@Autowired
	private RandomServiceClient randomServiceClient;
	
	/**
	 * Generate random value
	 * 
	 * @return
	 */
	@GetMapping(value = "/feign")
	public ResponseEntity<String> getRandonNumberUsingFeign() {
		LOG.log(Level.INFO, "feign");
		return ResponseEntity.ok(this.randomServiceClient.getRandonNumber());
	}
}
