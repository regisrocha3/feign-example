package rr.labs.feignexample.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client REST Random Service
 * 
 * @author regis.rocha
 *
 */
@FeignClient(name = "feign-services", url = "${feign.client.url}")
public interface RandomServiceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/random-service/random")
	String getRandonNumber();
	
}
