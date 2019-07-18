package com.omnicuris.ecommercebasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ECommerceBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceBasicApplication.class, args);
	}

}
