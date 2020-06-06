package org.petrveri.aw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AwApplication {
	private final static Logger log = LoggerFactory.getLogger(AwApplication.class);

	public static void main(String[] args) {
		String[] envNames = new String[] {"KEYVAULT_URI", "KEYVAULT_CLIENT_ID", "KEYVAULT_TENANT_ID", "KEYVAULT_KEY"};
		Arrays.stream(envNames).forEach(s -> log.info("{}:\t{}", s, System.getenv(s)));
		SpringApplication.run(AwApplication.class, args);
	}
}
