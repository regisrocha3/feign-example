package rr.labs.feignexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Start the application
 * 
 * @author regis.rocha
 *
 */
@EnableFeignClients(basePackages = "rr.labs.feignexample.service.client")
@SpringBootApplication
public class FeignExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignExampleApplication.class, args);
	}

}
