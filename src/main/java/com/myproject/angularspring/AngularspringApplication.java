package com.myproject.angularspring;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AngularspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularspringApplication.class, args);
		// byte[] randomBytes = new byte[32];
        // SecureRandom secureRandom = new SecureRandom();
        // secureRandom.nextBytes(randomBytes);

        // String secretKey = Base64.getEncoder().encodeToString(randomBytes);

        // System.out.println("Generated Secret Key: " + secretKey);
	}

}
