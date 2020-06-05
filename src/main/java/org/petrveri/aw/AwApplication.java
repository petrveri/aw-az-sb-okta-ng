package org.petrveri.aw;

//import org.petrveri.aw.config.SomeSecurityConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
//@EnableConfigurationProperties(SomeSecurityConfiguration.class)
@RestController
public class AwApplication implements CommandLineRunner {
	private final static Logger log = LoggerFactory.getLogger(AwApplication.class);

	@Autowired
	private Environment env;

	@Value("${fakeSecret}")
	private String fakeSecret;

	public static void main(String[] args) {
		String[] envNames = new String[] {"OKTA_CLIENT_ID", "OKTA_CLIENT_SECRET", "OKTA_ISSUER_URI",
				"KEYVAULT_URI", "KEYVAULT_CLIENT_ID", "KEYVAULT_TENANT_ID", "KEYVAULT_KEY"};
		Arrays.stream(envNames).forEach(s -> log.info("{}:\t{}", s, System.getenv(s)));
		SpringApplication.run(AwApplication.class, args);
	}

	@GetMapping("getSecret")
	public String getSecret() {
		return fakeSecret;
	}

	public void run(String... varl) {
		log.info("Fake Secret stored in Azure Key Vault:\t{}", fakeSecret);
	}
}
