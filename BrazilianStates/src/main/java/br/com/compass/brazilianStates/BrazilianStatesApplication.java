package br.com.compass.brazilianStates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class BrazilianStatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrazilianStatesApplication.class, args);
	}

}
