package com.EWallet.Venmo;

import jakarta.persistence.OneToOne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VenmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VenmoApplication.class, args);
	}

}
