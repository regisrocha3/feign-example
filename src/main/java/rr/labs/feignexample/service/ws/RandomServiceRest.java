package rr.labs.feignexample.service.ws;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Servico para geracao de numero randomico
 * 
 * @author regis.rocha
 *
 */
@RestController(value = "/random-service")
public class RandomServiceRest {
	
	/**
	 * LOG
	 */
	private Logger LOG = Logger.getLogger(RandomServiceRest.class.getName());
	
	/**
	 * Generate random value
	 * 
	 * @return
	 */
	@GetMapping(value = "/random-service/random")
	public ResponseEntity<String> getRandonNumber() {
		LOG.log(Level.INFO, "getRandonNumber");
		return ResponseEntity.ok(String.valueOf(new Random().nextDouble()));
	}
}
