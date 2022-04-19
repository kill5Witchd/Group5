package com.capg.OnlineSeatBooking.AdminstrationOfficeDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AdminstrationOfficeDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminstrationOfficeDetailsApplication.class, args);
	}

}
