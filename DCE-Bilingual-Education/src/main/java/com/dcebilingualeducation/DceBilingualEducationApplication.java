package com.dcebilingualeducation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DceBilingualEducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DceBilingualEducationApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}

}