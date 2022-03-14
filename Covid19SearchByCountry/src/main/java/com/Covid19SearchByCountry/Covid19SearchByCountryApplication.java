package com.Covid19SearchByCountry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
/**
 * 
 * @author Suguna
 *
 */
@SpringBootApplication
@CrossOrigin(origins ="*")
public class Covid19SearchByCountryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19SearchByCountryApplication.class, args);
	}

}
